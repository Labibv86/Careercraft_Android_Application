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
import com.example.careercraft.ui.theme.Black
import com.example.careercraft.ui.theme.White

@Composable
fun SplashScreen(
    onNavigateToLogin: () -> Unit,
    onNavigateToDashboard: () -> Unit
) {
    LaunchedEffect(Unit) {
        val userId = AuthRepository().currentUserId()
        if (userId != null) onNavigateToDashboard() else onNavigateToLogin()
    }
    Box(
        modifier = Modifier.fillMaxSize().background(Black),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = White)
    }
}