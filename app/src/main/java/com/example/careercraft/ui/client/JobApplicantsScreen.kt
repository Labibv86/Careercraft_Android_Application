package com.example.careercraft.ui.client

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.careercraft.ui.theme.*

@Composable

fun JobApplicantsScreen(
    jobId: String,
    onHired: (String) -> Unit,
    viewModel: JobApplicantsViewModel = viewModel(factory = JobApplicantsViewModelFactory(jobId))
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {
        val state = uiState
        if (state is JobApplicantsUiState.Hired) onHired(state.contractId)
    }

    Box(modifier = Modifier.fillMaxSize().background(White)) {
        when (val state = uiState) {
            is JobApplicantsUiState.Loading, is JobApplicantsUiState.Hired ->
                CircularProgressIndicator(color = Black, modifier = Modifier.align(Alignment.Center))
            is JobApplicantsUiState.Error -> Text(state.message, color = Red, modifier = Modifier.align(Alignment.Center).padding(24.dp))
            is JobApplicantsUiState.Ready -> {
                if (state.applicants.isEmpty()) {
                    Text("No applicants yet.", color = Black, modifier = Modifier.align(Alignment.Center).padding(24.dp))
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize().padding(24.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        item {
                            Text("Applicants (${state.applicants.size})", style = MaterialTheme.typography.titleLarge, color = Black)
                            Spacer(Modifier.height(4.dp))
                        }
                        items(state.applicants, key = { it.proposalId }) { proposal ->
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(LightGrey)
                                    .padding(16.dp)
                            ) {
                                Text("${proposal.users.displayName} \u2014 ${proposal.users.ratingScore}", style = MaterialTheme.typography.titleMedium, color = Black)
                                Spacer(Modifier.height(4.dp))
                                Text("\$${proposal.proposedRate.toInt()} \u00B7 ${proposal.estimatedTimeline}", color = Grey, style = MaterialTheme.typography.bodyMedium)
                                Spacer(Modifier.height(4.dp))
                                Text(proposal.coverLetter, color = Black, style = MaterialTheme.typography.bodyMedium, maxLines = 3)
                                if (proposal.status == "pending") {
                                    Spacer(Modifier.height(10.dp))
                                    Button(
                                        onClick = { viewModel.hire(proposal.proposalId) },
                                        modifier = Modifier.fillMaxWidth().height(40.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = DeepGrey, contentColor = White)
                                    ) { Text("HIRE") }
                                } else {
                                    Spacer(Modifier.height(6.dp))
                                    Text(proposal.status.uppercase(), color = Grey, style = MaterialTheme.typography.labelSmall)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}