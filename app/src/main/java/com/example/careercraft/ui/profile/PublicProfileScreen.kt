package com.example.careercraft.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.careercraft.ui.theme.Black
import com.example.careercraft.ui.theme.White

@Composable
fun PublicProfileScreen(userId: String) {
    Box(modifier = Modifier.fillMaxSize().background(White), contentAlignment = Alignment.Center) {
        Text(
            "Public profile coming soon.\n(user: $userId)",
            style = MaterialTheme.typography.bodyLarge,
            color = Black,
            modifier = Modifier.padding(24.dp)
        )
    }
}