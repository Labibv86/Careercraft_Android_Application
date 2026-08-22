package com.example.careercraft.ui.payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.models.PaymentCard
import com.example.careercraft.data.models.PaymentResponse
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.PaymentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class PaymentUiState {
    data object Idle : PaymentUiState()
    data object Processing : PaymentUiState()
    data class Success(val response: PaymentResponse) : PaymentUiState()
    data class Error(val message: String) : PaymentUiState()
}

class PaymentViewModel(
    private val paymentRepository: PaymentRepository = PaymentRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<PaymentUiState>(PaymentUiState.Idle)
    val uiState: StateFlow<PaymentUiState> = _uiState.asStateFlow()

    fun processPayment(
        contractId: String,
        freelancerId: String,
        amount: Double,
        jobTitle: String,
        cardNumber: String,
        cardHolderName: String,
        expiryMonth: String,
        expiryYear: String,
        cvv: String
    ) {
        val clientId = authRepository.currentUserId()
        if (clientId == null) {
            _uiState.value = PaymentUiState.Error("Session expired. Please log in again.")
            return
        }

        // Validate inputs
        if (cardNumber.replace(" ", "").length < 16) {
            _uiState.value = PaymentUiState.Error("Please enter a valid card number.")
            return
        }

        if (cardHolderName.isBlank()) {
            _uiState.value = PaymentUiState.Error("Please enter card holder name.")
            return
        }

        val month = expiryMonth.toIntOrNull()
        val year = expiryYear.toIntOrNull()
        if (month == null || year == null || month !in 1..12 || year < 2024) {
            _uiState.value = PaymentUiState.Error("Please enter valid expiry date.")
            return
        }

        if (cvv.length !in 3..4 || !cvv.all { it.isDigit() }) {
            _uiState.value = PaymentUiState.Error("Please enter valid CVV (3-4 digits).")
            return
        }

        val card = PaymentCard(
            cardNumber = cardNumber,
            cardHolderName = cardHolderName,
            expiryMonth = month,
            expiryYear = year,
            cvv = cvv
        )

        _uiState.value = PaymentUiState.Processing

        viewModelScope.launch {
            try {
                val response = paymentRepository.processPayment(
                    contractId = contractId,
                    clientId = clientId,
                    freelancerId = freelancerId,
                    amount = amount,
                    jobTitle = jobTitle,
                    card = card
                )

                if (response.status == "completed") {
                    _uiState.value = PaymentUiState.Success(response)
                } else {
                    _uiState.value = PaymentUiState.Error("Payment failed. Please check your card details.")
                }
            } catch (e: Exception) {
                _uiState.value = PaymentUiState.Error(e.message ?: "Payment processing failed.")
            }
        }
    }

    fun resetState() {
        _uiState.value = PaymentUiState.Idle
    }
}