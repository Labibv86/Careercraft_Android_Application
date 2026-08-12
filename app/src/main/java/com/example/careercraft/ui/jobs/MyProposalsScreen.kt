package com.example.careercraft.ui.jobs


import androidx.compose.foundation.clickable
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

private val tabs = listOf("Pending", "Accepted", "Rejected", "Withdrawn")
private fun statusFor(tab: String) = tab.lowercase()

@Composable
fun MyProposalsScreen(viewModel: MyProposalsViewModel = viewModel()) {
    var selectedTab by remember { mutableStateOf("Pending") }
    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize().background(White)) {
        Text(
            "My Proposals",
            style = MaterialTheme.typography.titleLarge,
            color = Black,
            modifier = Modifier.padding(24.dp, 24.dp, 24.dp, 8.dp)
        )
        Row(
            modifier = Modifier.padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            tabs.forEach { tab ->
                Text(
                    tab,
                    color = if (tab == selectedTab) Black else Grey,
                    style = if (tab == selectedTab) MaterialTheme.typography.labelSmall else MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.clip(RoundedCornerShape(6.dp)).clickable { selectedTab = tab }.padding(vertical = 6.dp)
                )
            }
        }
        Spacer(Modifier.height(12.dp))

        when (val state = uiState) {
            is MyProposalsUiState.Loading -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Black)
            }
            is MyProposalsUiState.Error -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(state.message, color = Red, modifier = Modifier.padding(24.dp))
            }
            is MyProposalsUiState.Ready -> {
                val filtered = state.proposals.filter { it.status == statusFor(selectedTab) }
                if (filtered.isEmpty()) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("No ${selectedTab.lowercase()} proposals.", color = Grey)
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.padding(horizontal = 24.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(filtered, key = { it.proposalId }) { proposal ->
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(LightGrey)
                                    .padding(16.dp)
                            ) {
                                Text(proposal.jobs.title, style = MaterialTheme.typography.titleMedium, color = Black)
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    "\$${proposal.proposedRate.toInt()} \u00B7 ${proposal.estimatedTimeline}",
                                    color = Grey,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                if (proposal.status == "pending") {
                                    Spacer(Modifier.height(8.dp))
                                    TextButton(
                                        onClick = { viewModel.withdraw(proposal.proposalId) },
                                        contentPadding = PaddingValues(0.dp)
                                    ) {
                                        Text("WITHDRAW", color = Red, style = MaterialTheme.typography.labelSmall)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}