package com.example.careercraft.ui.contracts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
fun ContractDetailScreen(
    contractId: String,
    onOpenChat: (String) -> Unit,
    onNeedsRating: (String) -> Unit,
    onShowHistory: (String) -> Unit,
    navController: NavHostController = rememberNavController(),
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

                    // Other party with clickable profile
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable {
                                navController.navigate(Routes.publicProfile(data.otherPartyId))
                            }
                            .padding(vertical = 4.dp)
                    ) {
                        ProfilePicture(
                            photoUrl = data.otherPartyPhotoUrl,
                            displayName = data.otherPartyName,
                            size = 32
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            "${if (data.isFreelancer) "Client" else "Freelancer"}: ${data.otherPartyName} (${data.otherPartyRating})",
                            color = Black,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Spacer(Modifier.height(4.dp))
                    Text("Pay: $${data.contract.payAmount.toInt()} · Duration: ${data.contract.duration}", color = Grey, style = MaterialTheme.typography.bodyMedium)
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