package com.example.careercraft.ui.contracts

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
import com.example.careercraft.ui.common.DashboardCard
import com.example.careercraft.ui.theme.*

@Composable
fun HistoryScreen(
    contractId: String,
    onViewProfile: (String) -> Unit,
    viewModel: HistoryViewModel = viewModel(factory = HistoryViewModelFactory(contractId))
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize().background(White)) {
        when (val state = uiState) {
            is HistoryUiState.Loading -> CircularProgressIndicator(color = Black, modifier = Modifier.align(Alignment.Center))
            is HistoryUiState.Error -> Text(state.message, color = Red, modifier = Modifier.align(Alignment.Center).padding(24.dp))
            is HistoryUiState.Ready -> {
                val data = state.data
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text("Contract History", style = MaterialTheme.typography.titleLarge, color = Black)
                    Spacer(Modifier.height(4.dp))
                    Text("Completed", color = Grey, style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(16.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(LightGrey, shape = androidx.compose.foundation.shape.RoundedCornerShape(14.dp))
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "${if (data.isFreelancer) "Client" else "Freelancer"}: ${data.otherPartyName}",
                            style = MaterialTheme.typography.titleMedium, color = Black
                        )
                        TextButton(onClick = { onViewProfile(data.otherPartyId) }) {
                            Text("VIEW PROFILE", color = DeepGrey)
                        }
                    }
                    Spacer(Modifier.height(16.dp))

                    Text("Job Post", style = MaterialTheme.typography.titleMedium, color = Black)
                    Spacer(Modifier.height(8.dp))
                    DashboardCard(title = data.job.title, subtitle = data.job.description)
                    Spacer(Modifier.height(6.dp))
                    DashboardCard(
                        title = "\uD83D\uDCB0 \$${data.job.payMin.toInt()}-${data.job.payMax.toInt()}",
                        subtitle = "\u23F1 ${data.job.duration} \u00B7 \uD83D\uDCCD ${data.job.locationType}"
                    )
                    Spacer(Modifier.height(16.dp))

                    Text("Proposal", style = MaterialTheme.typography.titleMedium, color = Black)
                    Spacer(Modifier.height(8.dp))
                    DashboardCard(title = data.proposal.coverLetter, subtitle = "\$${data.proposal.proposedRate.toInt()} \u00B7 ${data.proposal.estimatedTimeline}")
                    Spacer(Modifier.height(16.dp))

                    Text("Review & Feedback", style = MaterialTheme.typography.titleMedium, color = Black)
                    Spacer(Modifier.height(8.dp))
                    if (data.myReview != null) {
                        DashboardCard(
                            title = "You rated: ${data.myReview.rating}",
                            subtitle = data.myReview.feedback ?: "No feedback left"
                        )
                        Spacer(Modifier.height(6.dp))
                    }
                    if (data.theirReview != null) {
                        DashboardCard(
                            title = "${data.otherPartyName} rated: ${data.theirReview.rating}",
                            subtitle = data.theirReview.feedback ?: "No feedback left"
                        )
                    } else {
                        Text("${data.otherPartyName} hasn't left a review yet.", color = Grey, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}