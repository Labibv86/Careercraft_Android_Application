package com.example.careercraft.ui.client

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.careercraft.ui.common.DashboardCard
import com.example.careercraft.ui.theme.*
import androidx.compose.runtime.LaunchedEffect

@Composable
fun ClientHomeScreen(
    onPostJob: () -> Unit,
    onMyJobs: () -> Unit,
    onMessages: () -> Unit,
    onSignedOut: () -> Unit,
    viewModel: ClientDashboardViewModel = viewModel()
) {
    LaunchedEffect(Unit) { viewModel.refresh() }
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize().background(White)) {
        when (val state = uiState) {
            is ClientDashboardUiState.Loading -> CircularProgressIndicator(color = Black, modifier = Modifier.align(Alignment.Center))
            is ClientDashboardUiState.Error -> Text(state.message, color = Red, modifier = Modifier.align(Alignment.Center).padding(24.dp))
            is ClientDashboardUiState.Ready -> {
                val data = state.data
                Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Hi, ${data.profile.displayName} \uD83D\uDC4B", style = MaterialTheme.typography.titleLarge, color = Black)
                        TextButton(onClick = { viewModel.signOut(onSignedOut) }) {
                            Text("Log Out", color = Red)
                        }
                    }
                    Spacer(Modifier.height(20.dp))

                    DashboardCard(title = "Active Jobs: ${data.activeJobs}", subtitle = "Applications Received: ${data.applicationsReceived}")
                    Spacer(Modifier.height(12.dp))
                    DashboardCard(
                        title = "Active Contracts: ${data.activeContracts}",
                        subtitle = "Rating: ${if (data.profile.totalReviews > 0) data.profile.ratingScore else "No ratings yet"}"
                    )
                    Spacer(Modifier.height(20.dp))

                    Button(
                        onClick = onPostJob,
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = DeepGrey, contentColor = White)
                    ) { Text("\uD83D\uDCDD POST JOB") }
                    Spacer(Modifier.height(10.dp))
                    Button(
                        onClick = onMyJobs,
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = LightGrey, contentColor = Black)
                    ) { Text("\uD83D\uDCCA MY JOBS") }
                    Spacer(Modifier.height(10.dp))
                    Button(
                        onClick = onMessages,
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = LightGrey, contentColor = Black)
                    ) { Text("\uD83D\uDCAC MESSAGES") }
                }
            }
        }
    }
}