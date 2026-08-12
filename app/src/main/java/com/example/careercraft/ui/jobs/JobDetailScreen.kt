package com.example.careercraft.ui.jobs

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
import com.example.careercraft.ui.theme.Grey
import com.example.careercraft.ui.theme.Red
import com.example.careercraft.ui.theme.White

@Composable
fun JobDetailScreen(
    jobId: String,
    onApply: (String) -> Unit,
    viewModel: JobDetailViewModel = viewModel(factory = JobDetailViewModelFactory(jobId))
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize().background(White)) {
        when (val state = uiState) {
            is JobDetailUiState.Loading -> CircularProgressIndicator(color = Black, modifier = Modifier.align(Alignment.Center))
            is JobDetailUiState.Error -> Text(state.message, color = Red, modifier = Modifier.align(Alignment.Center).padding(24.dp))
            is JobDetailUiState.Ready -> {
                val job = state.job
                Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
                    Text(job.title, style = MaterialTheme.typography.titleLarge, color = Black)
                    Spacer(Modifier.height(4.dp))
                    Text(
                        "\uD83D\uDCB0 $${job.payMin.toInt()}-${job.payMax.toInt()}   \u23F1 ${job.duration}   \uD83D\uDCCD ${job.locationType}",
                        color = Grey,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(Modifier.height(16.dp))
                    Text(job.description, color = Black, style = MaterialTheme.typography.bodyLarge)
                    Spacer(Modifier.height(16.dp))
                    DashboardCard(title = "Required Skills", subtitle = job.requiredSkills.joinToString(" \u00B7 "))
                    Spacer(Modifier.height(24.dp))
                    Button(
                        onClick = { onApply(job.jobId) },
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = DeepGrey, contentColor = White)
                    ) { Text("APPLY NOW") }
                }
            }
        }
    }
}