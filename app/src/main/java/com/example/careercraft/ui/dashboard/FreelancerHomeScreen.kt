package com.example.careercraft.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.careercraft.ui.common.DashboardCard
import com.example.careercraft.ui.theme.Black
import com.example.careercraft.ui.theme.DeepGrey
import com.example.careercraft.ui.theme.LightGrey
import com.example.careercraft.ui.theme.Red
import com.example.careercraft.ui.theme.White

@Composable
fun FreelancerHomeScreen(
    onFindJobs: () -> Unit,
    onPortfolio: () -> Unit,
    onMessages: () -> Unit,
    onProposals: () -> Unit,
    onSignedOut: () -> Unit,
    viewModel: DashboardViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize().background(White)) {
        when (val state = uiState) {
            is DashboardUiState.Loading -> CircularProgressIndicator(
                color = Black,
                modifier = Modifier.align(Alignment.Center)
            )
            is DashboardUiState.Error -> Text(
                state.message,
                color = Red,
                modifier = Modifier.align(Alignment.Center).padding(24.dp)
            )
            is DashboardUiState.Ready -> {
                val profile = state.profile
                Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Hi, ${profile.displayName} \uD83D\uDC4B", style = MaterialTheme.typography.titleLarge, color = Black)
                        TextButton(onClick = { viewModel.signOut(onSignedOut) }) {
                            Text("Log Out", color = Red)
                        }
                    }
                    Spacer(Modifier.height(20.dp))

                    DashboardCard(
                        title = "Career Path: ${profile.careerPath ?: "Not set"}",
                        subtitle = "Profile ${profile.profilePercent}% complete"
                    )
                    Spacer(Modifier.height(12.dp))
                    DashboardCard(
                        title = "Rating: ${if (profile.totalReviews > 0) profile.ratingScore else "No ratings yet"}",
                        subtitle = "Based on ${profile.totalReviews} review(s)"
                    )
                    Spacer(Modifier.height(20.dp))

                    Button(
                        onClick = onFindJobs,
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = DeepGrey, contentColor = White)
                    ) { Text("\uD83D\uDD0D FIND JOBS") }
                    Spacer(Modifier.height(10.dp))
                    Button(
                        onClick = onPortfolio,
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = LightGrey, contentColor = Black)
                    ) { Text("\uD83D\uDCC2 MY PORTFOLIO") }
                    Spacer(Modifier.height(10.dp))
                    Button(
                        onClick = onMessages,
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = LightGrey, contentColor = Black)
                    ) { Text("\uD83D\uDCAC MESSAGES") }
                    Spacer(Modifier.height(10.dp))
                    Button(
                        onClick = onProposals,
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = LightGrey, contentColor = Black)
                    ) { Text("\uD83D\uDCCB MY PROPOSALS") }
                }
            }
        }
    }
}