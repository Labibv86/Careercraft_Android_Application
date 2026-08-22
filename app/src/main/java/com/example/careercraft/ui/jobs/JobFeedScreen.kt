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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.careercraft.ui.common.ProfilePicture
import com.example.careercraft.ui.theme.*
import com.example.careercraft.navigation.Routes

@Composable
fun JobFeedScreen(
    onJobClick: (String) -> Unit,
    navController: NavHostController = rememberNavController(),
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
                        items(state.jobs, key = { it.job.jobId }) { jobWithClient ->
                            val job = jobWithClient.job
                            val client = jobWithClient.client

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(LightGrey, shape = androidx.compose.foundation.shape.RoundedCornerShape(14.dp))
                                    .clickable { onJobClick(job.jobId) }
                                    .padding(16.dp)
                            ) {
                                Text(job.title, style = MaterialTheme.typography.titleMedium, color = Black)
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    "💰 $${job.payMin.toInt()}-${job.payMax.toInt()} · ⏱ ${job.duration} · 📍 ${job.locationType}",
                                    color = Grey,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Spacer(Modifier.height(8.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    // View Client Profile Button with Profile Picture
                                    TextButton(
                                        onClick = {
                                            navController.navigate(Routes.publicProfile(job.clientId))
                                        },
                                        modifier = Modifier.padding(0.dp),
                                        contentPadding = PaddingValues(0.dp)
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                                        ) {
                                            ProfilePicture(
                                                photoUrl = client.photoUrl,
                                                displayName = client.displayName,
                                                size = 24
                                            )
                                            Text(
                                                client.displayName,
                                                color = DeepGrey,
                                                style = MaterialTheme.typography.labelMedium
                                            )
                                        }
                                    }
                                    Spacer(Modifier.weight(1f))
                                    Text(
                                        job.status.uppercase(),
                                        color = if (job.status == "open") DeepGrey else Grey,
                                        style = MaterialTheme.typography.labelSmall
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