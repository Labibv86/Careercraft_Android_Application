package com.example.careercraft.ui.contracts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.careercraft.ui.theme.*

@Composable
fun ContractDetailScreen(
    contractId: String,
    onOpenChat: (String) -> Unit,
    onNeedsRating: (String) -> Unit,
    onShowHistory: (String) -> Unit,
    viewModel: ContractDetailViewModel = viewModel(factory = ContractDetailViewModelFactory(contractId))
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {
        when (val state = uiState) {
            is ContractDetailUiState.NeedsRating -> onNeedsRating(state.contractId)
            is ContractDetailUiState.ShowHistory -> onShowHistory(state.contractId)
            else -> {}
        }
    }

    Box(modifier = Modifier.fillMaxSize().background(White)) {
        when (val state = uiState) {
            is ContractDetailUiState.Loading, is ContractDetailUiState.NeedsRating, is ContractDetailUiState.ShowHistory ->
                CircularProgressIndicator(color = Black, modifier = Modifier.align(Alignment.Center))
            is ContractDetailUiState.Error -> Text(state.message, color = Red, modifier = Modifier.align(Alignment.Center).padding(24.dp))
            is ContractDetailUiState.Ready -> {
                val data = state.data
                Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
                    Text(data.jobTitle, style = MaterialTheme.typography.titleLarge, color = Black)
                    Spacer(Modifier.height(4.dp))
                    Text(
                        "${if (data.isFreelancer) "Client" else "Freelancer"}: ${data.otherPartyName} (${data.otherPartyRating})",
                        color = Black, style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(Modifier.height(4.dp))
                    Text("Pay: \$${data.contract.payAmount.toInt()} \u00B7 Duration: ${data.contract.duration}", color = Grey, style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(4.dp))
                    Text("Status: ${data.contract.status}", color = Grey, style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(24.dp))

                    Button(
                        onClick = { onOpenChat(data.contract.contractId) },
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = LightGrey, contentColor = Black)
                    ) { Text("OPEN CHAT") }
                    Spacer(Modifier.height(10.dp))
                    Button(
                        onClick = { viewModel.markComplete() },
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = DeepGrey, contentColor = White),
                        enabled = !data.myPartComplete
                    ) { Text(if (data.myPartComplete) "WAITING FOR OTHER PARTY" else "MARK COMPLETE") }
                }
            }
        }
    }
}