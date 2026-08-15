package com.example.careercraft.ui.client

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.careercraft.ui.common.DashboardCard
import com.example.careercraft.ui.theme.Black
import com.example.careercraft.ui.theme.Red
import com.example.careercraft.ui.theme.White
import kotlinx.coroutines.launch

@Composable
fun MyJobsScreen(
    onViewApplicants: (String) -> Unit,
    onViewContract: (String) -> Unit,
    viewModel: MyJobsViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize().background(White)) {
        when (val state = uiState) {
            is MyJobsUiState.Loading -> CircularProgressIndicator(color = Black, modifier = Modifier.align(Alignment.Center))
            is MyJobsUiState.Error -> Text(state.message, color = Red, modifier = Modifier.align(Alignment.Center).padding(24.dp))
            is MyJobsUiState.Ready -> {
                if (state.jobs.isEmpty()) {
                    Text("You haven't posted any jobs yet.", color = Black, modifier = Modifier.align(Alignment.Center).padding(24.dp))
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize().padding(24.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        item {
                            Text("My Jobs", style = MaterialTheme.typography.titleLarge, color = Black)
                            Spacer(Modifier.height(4.dp))
                        }
                        items(state.jobs, key = { it.jobId }) { job ->
                            DashboardCard(
                                title = job.title,
                                subtitle = "${job.totalApplicants} applicant(s) \u00B7 ${job.status}",
                                modifier = Modifier.clickable {
                                    if (job.status == "open") {
                                        onViewApplicants(job.jobId)
                                    } else {
                                        scope.launch {
                                            viewModel.resolveContractId(job.jobId)?.let { onViewContract(it) }
                                        }
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}