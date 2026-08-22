package com.example.careercraft.ui.payment

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.careercraft.ui.theme.careerCraftTextFieldColors
import com.example.careercraft.ui.theme.Black
import com.example.careercraft.ui.theme.Grey

@Composable
fun PaymentCardInput(
    cardNumber: String,
    onCardNumberChange: (String) -> Unit,
    cardHolderName: String,
    onCardHolderNameChange: (String) -> Unit,
    expiryMonth: String,
    onExpiryMonthChange: (String) -> Unit,
    expiryYear: String,
    onExpiryYearChange: (String) -> Unit,
    cvv: String,
    onCvvChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "Payment Details",
            style = MaterialTheme.typography.titleMedium,
            color = Black
        )

        // Card Number
        OutlinedTextField(
            value = cardNumber,
            onValueChange = {
                // Format: xxxx xxxx xxxx xxxx
                val cleaned = it.replace(" ", "").replace("-", "")
                val formatted = cleaned.chunked(4).joinToString(" ")
                if (formatted.length <= 19) onCardNumberChange(formatted)
            },
            label = { Text("Card Number") },
            placeholder = { Text("1234 5678 9012 3456") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = careerCraftTextFieldColors()
        )

        // Card Holder Name
        OutlinedTextField(
            value = cardHolderName,
            onValueChange = onCardHolderNameChange,
            label = { Text("Card Holder Name") },
            placeholder = { Text("John Doe") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = careerCraftTextFieldColors()
        )

        // Expiry Date Row
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = expiryMonth,
                onValueChange = {
                    if (it.length <= 2 && it.all { char -> char.isDigit() }) {
                        onExpiryMonthChange(it)
                    }
                },
                label = { Text("MM") },
                placeholder = { Text("12") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier.weight(1f),
                colors = careerCraftTextFieldColors()
            )

            OutlinedTextField(
                value = expiryYear,
                onValueChange = {
                    if (it.length <= 4 && it.all { char -> char.isDigit() }) {
                        onExpiryYearChange(it)
                    }
                },
                label = { Text("YYYY") },
                placeholder = { Text("2028") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier.weight(1f),
                colors = careerCraftTextFieldColors()
            )
        }

        // CVV
        OutlinedTextField(
            value = cvv,
            onValueChange = {
                if (it.length <= 4 && it.all { char -> char.isDigit() }) {
                    onCvvChange(it)
                }
            },
            label = { Text("CVV") },
            placeholder = { Text("123") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.5f),
            colors = careerCraftTextFieldColors()
        )
    }
}