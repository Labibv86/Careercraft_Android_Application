package com.example.careercraft.data.supabase

import com.example.careercraft.data.models.PaymentCard
import com.example.careercraft.data.models.PaymentRequest
import com.example.careercraft.data.models.PaymentResponse
import com.example.careercraft.data.models.TransactionRecord
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Order
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.Json
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

class PaymentRepository {
    private val postgrest = SupabaseClient.client.postgrest

    // Validate card (dummy validation)
    fun validateCard(card: PaymentCard): Boolean {
        // Check card number (simple Luhn check for demo)
        if (!isValidCardNumber(card.cardNumber)) return false

        // Check expiry date
        val currentYear = LocalDateTime.now().year
        val currentMonth = LocalDateTime.now().monthValue
        if (card.expiryYear < currentYear ||
            (card.expiryYear == currentYear && card.expiryMonth < currentMonth)) {
            return false
        }

        // Check CVV (3 or 4 digits)
        if (card.cvv.length !in 3..4 || !card.cvv.all { it.isDigit() }) return false

        // Check card holder name not empty
        if (card.cardHolderName.isBlank()) return false

        return true
    }

    private fun isValidCardNumber(cardNumber: String): Boolean {
        // Remove spaces and dashes
        val cleaned = cardNumber.replace(" ", "").replace("-", "")
        if (!cleaned.all { it.isDigit() }) return false

        // Luhn algorithm (simplified)
        var sum = 0
        var alternate = false
        for (i in cleaned.length - 1 downTo 0) {
            var n = cleaned[i].digitToInt()
            if (alternate) {
                n *= 2
                if (n > 9) n -= 9
            }
            sum += n
            alternate = !alternate
        }
        return sum % 10 == 0
    }

    fun getCardType(cardNumber: String): String {
        val cleaned = cardNumber.replace(" ", "").replace("-", "")
        return when {
            cleaned.startsWith("4") -> "VISA"
            cleaned.startsWith("5") -> "MasterCard"
            cleaned.startsWith("34") || cleaned.startsWith("37") -> "American Express"
            cleaned.startsWith("6") -> "Discover"
            else -> "Unknown"
        }
    }

    fun maskCardNumber(cardNumber: String): String {
        val cleaned = cardNumber.replace(" ", "").replace("-", "")
        val lastFour = cleaned.takeLast(4)
        return "•••• •••• •••• $lastFour"
    }

    suspend fun processPayment(
        contractId: String,
        clientId: String,
        freelancerId: String,
        amount: Double,
        jobTitle: String,
        card: PaymentCard
    ): PaymentResponse {
        // Validate card
        if (!validateCard(card)) {
            return PaymentResponse(
                transactionId = "",
                contractId = contractId,
                amount = amount,
                status = "failed",
                paymentDate = "",
                cardLastFour = ""
            )
        }

        // Generate transaction ID
        val transactionId = UUID.randomUUID().toString()
        val paymentDate = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        val cardLastFour = card.cardNumber.takeLast(4)

        // Update contract with payment status
        postgrest.from("contracts").update(
            buildJsonObject {
                put("payment_status", "paid")
                put("transaction_id", transactionId)
                put("payment_date", paymentDate)
            }
        ) {
            filter { eq("contract_id", contractId) }
        }

        // Insert transaction record
        postgrest.from("transactions").insert(
            buildJsonObject {
                put("transaction_id", transactionId)
                put("contract_id", contractId)
                put("amount", amount)
                put("status", "completed")
                put("payment_date", paymentDate)
                put("card_last_four", cardLastFour)
            }
        )

        return PaymentResponse(
            transactionId = transactionId,
            contractId = contractId,
            amount = amount,
            status = "completed",
            paymentDate = paymentDate,
            cardLastFour = cardLastFour
        )
    }

    suspend fun getTransaction(transactionId: String): TransactionRecord? {
        return postgrest.from("transactions")
            .select {
                filter { eq("transaction_id", transactionId) }
            }
            .decodeSingleOrNull()
    }

    suspend fun getTransactionsForContract(contractId: String): List<TransactionRecord> {
        return postgrest.from("transactions")
            .select {
                filter { eq("contract_id", contractId) }
                order("payment_date", Order.DESCENDING)
            }
            .decodeList()
    }

    suspend fun getTransactionsForUser(userId: String): List<TransactionRecord> {
        // Get transactions where user is either client or freelancer
        val asClient = postgrest.from("transactions_with_details")
            .select {
                filter { eq("client_id", userId) }
                order("payment_date", Order.DESCENDING)
            }
            .decodeList<TransactionRecord>()

        val asFreelancer = postgrest.from("transactions_with_details")
            .select {
                filter { eq("freelancer_id", userId) }
                order("payment_date", Order.DESCENDING)
            }
            .decodeList<TransactionRecord>()

        return (asClient + asFreelancer).distinctBy { it.transactionId }
    }
}