package com.example.careercraft.ui.jobs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.careercraft.ui.theme.*

@Composable
fun ProposalFormScreen(
    jobId: String,
    onSubmitted: () -> Unit,
    viewModel: ProposalFormViewModel = viewModel(factory = ProposalFormViewModelFactory(jobId))
) {
    var coverLetter by remember { mutableStateOf("") }
    var rate by remember { mutableStateOf("") }
    var timeline by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {
        if (uiState is ProposalUiState.Success) onSubmitted()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Submit Proposal", style = MaterialTheme.typography.titleLarge, color = Black)
        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            value = coverLetter,
            onValueChange = { coverLetter = it },
            label = { Text("Cover Letter") },
            minLines = 4,
            modifier = Modifier.fillMaxWidth(),
            colors = careerCraftTextFieldColors()
        )
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(
            value = rate,
            onValueChange = { rate = it },
            label = { Text("Proposed Rate ($)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = careerCraftTextFieldColors()
        )
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(
            value = timeline,
            onValueChange = { timeline = it },
            label = { Text("Estimated Timeline") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = careerCraftTextFieldColors()
        )

        if (uiState is ProposalUiState.Error) {
            Spacer(Modifier.height(8.dp))
            Text((uiState as ProposalUiState.Error).message, color = Red, style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { viewModel.submit(coverLetter, rate, timeline) },
            modifier = Modifier.fillMaxWidth().height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DeepGrey, contentColor = White),
            enabled = uiState !is ProposalUiState.Loading
        ) {
            if (uiState is ProposalUiState.Loading) {
                CircularProgressIndicator(modifier = Modifier.size(20.dp), color = White, strokeWidth = 2.dp)
            } else {
                Text("SUBMIT")
            }
        }
    }
}