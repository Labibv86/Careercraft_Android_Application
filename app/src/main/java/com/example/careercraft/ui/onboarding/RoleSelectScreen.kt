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
fun RoleSelectScreen(
    onFreelancerSelected: () -> Unit,
    onClientProfileCreated: () -> Unit,
    viewModel: OnboardingViewModel = viewModel()
) {
    var selectedRole by remember { mutableStateOf<String?>(null) }
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {
        if (uiState is ProfileUiState.Success) {
            onClientProfileCreated()
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
        Text("I am a...", style = MaterialTheme.typography.titleLarge, color = Black)
        Spacer(Modifier.height(24.dp))

        SelectableCard(
            title = "\uD83E\uDDD1\u200D\uD83D\uDCBB Freelancer",
            subtitle = "Looking for work and career guidance",
            selected = selectedRole == "freelancer",
            onClick = { selectedRole = "freelancer" }
        )
        Spacer(Modifier.height(12.dp))
        SelectableCard(
            title = "\uD83C\uDFE2 Client",
            subtitle = "Hiring talent for your projects",
            selected = selectedRole == "client",
            onClick = { selectedRole = "client" }
        )

        if (uiState is ProfileUiState.Error) {
            Spacer(Modifier.height(8.dp))
            Text((uiState as ProfileUiState.Error).message, color = Red, style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(Modifier.height(20.dp))
        Button(
            onClick = {
                when (selectedRole) {
                    "freelancer" -> onFreelancerSelected()
                    "client" -> viewModel.createProfile(role = "client", userType = "expert")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DeepGrey, contentColor = White),
            enabled = selectedRole != null && uiState !is ProfileUiState.Loading
        ) {
            if (uiState is ProfileUiState.Loading) {
                CircularProgressIndicator(modifier = Modifier.size(20.dp), color = White, strokeWidth = 2.dp)
            } else {
                Text("CONTINUE")
            }
        }
    }
}