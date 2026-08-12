package com.example.careercraft.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.careercraft.ui.common.SelectableCard
import com.example.careercraft.ui.theme.Black
import com.example.careercraft.ui.theme.DeepGrey
import com.example.careercraft.ui.theme.Red
import com.example.careercraft.ui.theme.White

@Composable
fun ExperienceLevelScreen(
    onBeginnerProfileCreated: () -> Unit,
    onExpertProfileCreated: () -> Unit,
    viewModel: OnboardingViewModel = viewModel()
) {
    var selectedLevel by remember { mutableStateOf<String?>(null) }
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {
        if (uiState is ProfileUiState.Success) {
            when (selectedLevel) {
                "beginner" -> onBeginnerProfileCreated()
                "expert" -> onExpertProfileCreated()
            }
            viewModel.resetState()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Your Experience", style = MaterialTheme.typography.titleLarge, color = Black)
        Spacer(Modifier.height(24.dp))

        SelectableCard(
            title = "\uD83C\uDF31 Beginner",
            subtitle = "New to freelancing, need career guidance",
            selected = selectedLevel == "beginner",
            onClick = { selectedLevel = "beginner" }
        )
        Spacer(Modifier.height(12.dp))
        SelectableCard(
            title = "\uD83D\uDCAA Expert",
            subtitle = "Experienced, know what I want",
            selected = selectedLevel == "expert",
            onClick = { selectedLevel = "expert" }
        )

        if (uiState is ProfileUiState.Error) {
            Spacer(Modifier.height(8.dp))
            Text((uiState as ProfileUiState.Error).message, color = Red, style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { selectedLevel?.let { viewModel.createProfile(role = "freelancer", userType = it) } },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DeepGrey, contentColor = White),
            enabled = selectedLevel != null && uiState !is ProfileUiState.Loading
        ) {
            if (uiState is ProfileUiState.Loading) {
                CircularProgressIndicator(modifier = Modifier.size(20.dp), color = White, strokeWidth = 2.dp)
            } else {
                Text("CONTINUE")
            }
        }
    }
}