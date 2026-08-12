package com.example.careercraft.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.UserRepository
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
            android.util.Log.d("CareerCraftDebug", "Splash resolved userId=$userId role='${profile.role}'")
            onNavigateToDashboard(profile.role)
        } catch (e: Exception) {
            android.util.Log.d("CareerCraftDebug", "Splash profile lookup failed: ${e.message}")
            onNavigateToLogin()
        }
    }
    Box(
        modifier = Modifier.fillMaxSize().background(Black),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = White)
    }
}