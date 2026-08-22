package com.example.careercraft.ui.payment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.careercraft.ui.theme.*

@Composable
fun PaymentScreen(
    contractId: String,
    freelancerId: String,
    amount: Double,
    jobTitle: String,
    onPaymentComplete: () -> Unit,
    viewModel: PaymentViewModel = viewModel()
) {
    var cardNumber by remember { mutableStateOf("") }
    var cardHolderName by remember { mutableStateOf("") }
    var expiryMonth by remember { mutableStateOf("") }
    var expiryYear by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }

    val uiState by viewModel.uiState.collectAsState()

    // Handle success state - refresh contract and go back
    LaunchedEffect(uiState) {
        if (uiState is PaymentUiState.Success) {
            onPaymentComplete()
        }
    }

    Box(modifier = Modifier.fillMaxSize().background(White)) {
        when (val state = uiState) {
            is PaymentUiState.Processing -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        CircularProgressIndicator(color = DeepGrey)
                        Text(
                            "Processing Payment...",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Grey
                        )
                    }
                }
            }
            is PaymentUiState.Success -> {
                // Show success briefly then navigate back
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text("✅", fontSize = MaterialTheme.typography.titleLarge.fontSize)
                        Text(
                            "Payment Successful!",
                            style = MaterialTheme.typography.titleLarge,
                            color = Black
                        )
                        Text(
                            "Redirecting...",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Grey
                        )
                    }
                }
            }
            else -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        "Clear Payment",
                        style = MaterialTheme.typography.titleLarge,
                        color = Black
                    )

                    Spacer(Modifier.height(8.dp))

                    // Payment summary
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = LightGrey)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                "Contract: $jobTitle",
                                style = MaterialTheme.typography.titleMedium,
                                color = Black
                            )
                            Text(
                                "Amount: $${amount.toInt()}",
                                style = MaterialTheme.typography.bodyLarge,
                                color = DeepGrey
                            )
                            Text(
                                "You're about to pay the freelancer for completed work.",
                                style = MaterialTheme.typography.bodySmall,
                                color = Grey
                            )
                        }
                    }

                    Spacer(Modifier.height(20.dp))

                    // Payment form
                    PaymentCardInput(
                        cardNumber = cardNumber,
                        onCardNumberChange = { cardNumber = it },
                        cardHolderName = cardHolderName,
                        onCardHolderNameChange = { cardHolderName = it },
                        expiryMonth = expiryMonth,
                        onExpiryMonthChange = { expiryMonth = it },
                        expiryYear = expiryYear,
                        onExpiryYearChange = { expiryYear = it },
                        cvv = cvv,
                        onCvvChange = { cvv = it }
                    )

                    if (state is PaymentUiState.Error) {
                        Spacer(Modifier.height(8.dp))
                        Text(
                            state.message,
                            color = Red,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }

                    Spacer(Modifier.height(20.dp))

                    Button(
                        onClick = {
                            viewModel.processPayment(
                                contractId = contractId,
                                freelancerId = freelancerId,
                                amount = amount,
                                jobTitle = jobTitle,
                                cardNumber = cardNumber,
                                cardHolderName = cardHolderName,
                                expiryMonth = expiryMonth,
                                expiryYear = expiryYear,
                                cvv = cvv
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = DeepGrey,
                            contentColor = White
                        ),
                        enabled = state !is PaymentUiState.Processing
                    ) {
                        if (state is PaymentUiState.Processing) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(20.dp),
                                color = White,
                                strokeWidth = 2.dp
                            )
                        } else {
                            Text("PAY NOW")
                        }
                    }

                    Spacer(Modifier.height(12.dp))

                    // Dummy card info for testing
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = LightGrey.copy(alpha = 0.5f))
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            Text(
                                "💳 Test Card Details:",
                                style = MaterialTheme.typography.labelMedium,
                                color = Grey
                            )
                            Text(
                                "VISA: 4111 1111 1111 1111",
                                style = MaterialTheme.typography.bodySmall,
                                color = Grey
                            )
                            Text(
                                "MasterCard: 5555 5555 5555 4444",
                                style = MaterialTheme.typography.bodySmall,
                                color = Grey
                            )
                            Text(
                                "Any future expiry date and CVV works",
                                style = MaterialTheme.typography.bodySmall,
                                color = Grey
                            )
                        }
                    }
                }
            }
        }
    }
}