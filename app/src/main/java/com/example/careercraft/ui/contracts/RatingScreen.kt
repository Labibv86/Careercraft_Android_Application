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
fun RatingScreen(
    contractId: String,
    onDone: () -> Unit,
    viewModel: RatingViewModel = viewModel(factory = RatingViewModelFactory(contractId))
) {
    var rating by remember { mutableFloatStateOf(0f) }
    var feedback by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {
        if (uiState is RatingUiState.Done) onDone()
    }

    Box(modifier = Modifier.fillMaxSize().background(White)) {
        when (val state = uiState) {
            is RatingUiState.Loading, is RatingUiState.Done ->
                CircularProgressIndicator(color = Black, modifier = Modifier.align(Alignment.Center))
            is RatingUiState.Error -> Text(state.message, color = Red, modifier = Modifier.align(Alignment.Center).padding(24.dp))
            is RatingUiState.Ready -> {
                Column(modifier = Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.Center) {
                    Text("Rate Your Experience", style = MaterialTheme.typography.titleLarge, color = Black)
                    Spacer(Modifier.height(4.dp))
                    Text("How was working with ${state.revieweeName}?", color = Grey, style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(24.dp))

                    Text("${rating.toInt()}", style = MaterialTheme.typography.titleLarge, color = Black)
                    Slider(
                        value = rating,
                        onValueChange = { rating = it },
                        valueRange = -10f..10f,
                        steps = 19,
                        colors = SliderDefaults.colors(thumbColor = DeepGrey, activeTrackColor = DeepGrey)
                    )
                    Spacer(Modifier.height(20.dp))

                    OutlinedTextField(
                        value = feedback,
                        onValueChange = { feedback = it },
                        label = { Text("Feedback (optional)") },
                        minLines = 3,
                        modifier = Modifier.fillMaxWidth(),
                        colors = careerCraftTextFieldColors()
                    )

                    Spacer(Modifier.height(20.dp))
                    Button(
                        onClick = { viewModel.submit(rating.toInt(), feedback) },
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = DeepGrey, contentColor = White)
                    ) { Text("SUBMIT") }
                    Spacer(Modifier.height(10.dp))
                    TextButton(onClick = { viewModel.skip() }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        Text("SKIP", color = Grey)
                    }
                }
            }
        }
    }
}