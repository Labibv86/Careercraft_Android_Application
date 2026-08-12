package com.example.careercraft.ui.jobs

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

@Composable
fun JobFeedScreen(
    onJobClick: (String) -> Unit,
    viewModel: JobFeedViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize().background(White)) {
        when (val state = uiState) {
            is JobFeedUiState.Loading -> CircularProgressIndicator(color = Black, modifier = Modifier.align(Alignment.Center))
            is JobFeedUiState.Error -> Text(state.message, color = Red, modifier = Modifier.align(Alignment.Center).padding(24.dp))
            is JobFeedUiState.Ready -> {
                if (state.jobs.isEmpty()) {
                    Text(
                        "No open jobs right now. Check back soon!",
                        color = Black,
                        modifier = Modifier.align(Alignment.Center).padding(24.dp)
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize().padding(24.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        item {
                            Text("Smart Job Feed", style = MaterialTheme.typography.titleLarge, color = Black)
                            Spacer(Modifier.height(4.dp))
                        }
                        items(state.jobs, key = { it.jobId }) { job ->
                            DashboardCard(
                                title = job.title,
                                subtitle = "\uD83D\uDCB0 $${job.payMin.toInt()}-${job.payMax.toInt()} \u00B7 \u23F1 ${job.duration} \u00B7 \uD83D\uDCCD ${job.locationType}",
                                modifier = Modifier.clickable { onJobClick(job.jobId) }
                            )
                        }
                    }
                }
            }
        }
    }
}