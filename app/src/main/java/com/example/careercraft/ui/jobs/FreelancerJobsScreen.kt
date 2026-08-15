package com.example.careercraft.ui.jobs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.careercraft.ui.theme.*

@Composable
fun FreelancerJobsScreen(
    onJobClick: (String) -> Unit,
    viewModel: FreelancerJobsViewModel = viewModel()
) {
    LaunchedEffect(Unit) { viewModel.refresh() }
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize().background(White)) {
        when (val state = uiState) {
            is FreelancerJobsUiState.Loading -> CircularProgressIndicator(color = Black, modifier = Modifier.align(Alignment.Center))
            is FreelancerJobsUiState.Error -> Text(state.message, color = Red, modifier = Modifier.align(Alignment.Center).padding(24.dp))
            is FreelancerJobsUiState.Ready -> {
                if (state.jobs.isEmpty()) {
                    Text("No jobs yet. Once you're hired, they'll show up here.", color = Black, modifier = Modifier.align(Alignment.Center).padding(24.dp))
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize().padding(24.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        item {
                            Text("My Jobs", style = MaterialTheme.typography.titleLarge, color = Black)
                            Spacer(Modifier.height(4.dp))
                        }
                        items(state.jobs, key = { it.contractId }) { job ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(LightGrey, shape = androidx.compose.foundation.shape.RoundedCornerShape(14.dp))
                                    .clickable { onJobClick(job.contractId) }
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                val dotColor = when (job.workStatus) {
                                    WorkStatus.ONGOING -> Color(0xFF4CAF50)
                                    WorkStatus.OVERDUE -> Red
                                    WorkStatus.FINISHED -> Grey
                                }
                                Box(modifier = Modifier.size(10.dp).clip(CircleShape).background(dotColor))
                                Spacer(Modifier.width(12.dp))
                                Column {
                                    Text(job.jobTitle, style = MaterialTheme.typography.titleMedium, color = Black)
                                    Text(
                                        "Client: ${job.clientName} \u00B7 ${job.workStatus.name.lowercase()}",
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Grey
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}