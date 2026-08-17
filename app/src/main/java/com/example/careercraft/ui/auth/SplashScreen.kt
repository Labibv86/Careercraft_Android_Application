package com.example.careercraft.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.UserRepository
import com.example.careercraft.ui.theme.Grey
import com.example.careercraft.ui.theme.Black
import com.example.careercraft.ui.theme.White

@Composable
fun SplashScreen(
    onNavigateToLogin: () -> Unit,
    onNavigateToDashboard: (role: String) -> Unit
) {
    LaunchedEffect(Unit) {
        val userId = AuthRepository().currentUserId()
        if (userId == null) {
            onNavigateToLogin()
            return@LaunchedEffect
        }
        try {
            val profile = UserRepository().getProfile(userId)
            onNavigateToDashboard(profile.role)
        } catch (e: Exception) {
            onNavigateToLogin()
        }
    }
    Box(
        modifier = Modifier.fillMaxSize().background(Black),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("CareerCraft", style = MaterialTheme.typography.titleLarge, color = White)
            Spacer(Modifier.height(4.dp))
            Text("AI-Powered Freelance Mentor", style = MaterialTheme.typography.bodyMedium, color = Grey)
            Spacer(Modifier.height(24.dp))
            CircularProgressIndicator(color = White)
        }
    }
}