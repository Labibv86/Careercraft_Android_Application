package com.example.careercraft.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PaymentCard(
    val cardNumber: String,
    val cardHolderName: String,
    val expiryMonth: Int,
    val expiryYear: Int,
    val cvv: String
)

@Serializable
data class PaymentRequest(
    @SerialName("contract_id") val contractId: String,
    @SerialName("client_id") val clientId: String,
    @SerialName("freelancer_id") val freelancerId: String,
    @SerialName("amount") val amount: Double,
    @SerialName("job_title") val jobTitle: String,
    val card: PaymentCard
)

@Serializable
data class PaymentResponse(
    @SerialName("transaction_id") val transactionId: String,
    @SerialName("contract_id") val contractId: String,
    @SerialName("amount") val amount: Double,
    @SerialName("status") val status: String, // "completed", "failed"
    @SerialName("payment_date") val paymentDate: String,
    @SerialName("card_last_four") val cardLastFour: String
)

@Serializable
data class TransactionRecord(
    @SerialName("transaction_id") val transactionId: String,
    @SerialName("contract_id") val contractId: String,
    @SerialName("job_title") val jobTitle: String,
    @SerialName("freelancer_name") val freelancerName: String,
    @SerialName("client_name") val clientName: String,
    @SerialName("amount") val amount: Double,
    @SerialName("status") val status: String,
    @SerialName("payment_date") val paymentDate: String,
    @SerialName("card_last_four") val cardLastFour: String
)