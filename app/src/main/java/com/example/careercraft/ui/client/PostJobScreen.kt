package com.example.careercraft.ui.client

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

private val categories = listOf("Technology", "Creative", "Physical", "Service")
private val locationTypes = listOf("Remote", "Hybrid", "On-site")

@Composable
fun PostJobScreen(
    onPosted: () -> Unit,
    viewModel: PostJobViewModel = viewModel()
) {
    var title by remember { mutableStateOf("") }
    var category by remember { mutableStateOf(categories[0]) }
    var description by remember { mutableStateOf("") }
    var skills by remember { mutableStateOf("") }
    var payMin by remember { mutableStateOf("") }
    var payMax by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var locationType by remember { mutableStateOf(locationTypes[0]) }
    var location by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {
        if (uiState is PostJobUiState.Success) onPosted()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("Post a Job", style = MaterialTheme.typography.titleLarge, color = Black)
        Spacer(Modifier.height(20.dp))

        OutlinedTextField(title, { title = it }, label = { Text("Title") }, singleLine = true, modifier = Modifier.fillMaxWidth(), colors = careerCraftTextFieldColors())
        Spacer(Modifier.height(12.dp))

        Text("Category", color = Grey, style = MaterialTheme.typography.labelSmall)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(top = 4.dp)) {
            categories.forEach { c ->
                FilterChip(selected = category == c, onClick = { category = c }, label = { Text(c) })
            }
        }
        Spacer(Modifier.height(12.dp))

        OutlinedTextField(description, { description = it }, label = { Text("Description (min 20 chars)") }, minLines = 3, modifier = Modifier.fillMaxWidth(), colors = careerCraftTextFieldColors())
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(skills, { skills = it }, label = { Text("Required Skills (comma-separated, min 3)") }, singleLine = true, modifier = Modifier.fillMaxWidth(), colors = careerCraftTextFieldColors())
        Spacer(Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlinedTextField(payMin, { payMin = it }, label = { Text("Pay Min ($)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), singleLine = true, modifier = Modifier.weight(1f), colors = careerCraftTextFieldColors())
            OutlinedTextField(payMax, { payMax = it }, label = { Text("Pay Max ($)") }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), singleLine = true, modifier = Modifier.weight(1f), colors = careerCraftTextFieldColors())
        }
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(duration, { duration = it }, label = { Text("Duration (e.g. 3 months)") }, singleLine = true, modifier = Modifier.fillMaxWidth(), colors = careerCraftTextFieldColors())
        Spacer(Modifier.height(12.dp))

        Text("Location Type", color = Grey, style = MaterialTheme.typography.labelSmall)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(top = 4.dp)) {
            locationTypes.forEach { l ->
                FilterChip(selected = locationType == l, onClick = { locationType = l }, label = { Text(l) })
            }
        }
        if (locationType == "On-site" || locationType == "Hybrid") {
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(location, { location = it }, label = { Text("Location") }, singleLine = true, modifier = Modifier.fillMaxWidth(), colors = careerCraftTextFieldColors())
        }

        if (uiState is PostJobUiState.Error) {
            Spacer(Modifier.height(8.dp))
            Text((uiState as PostJobUiState.Error).message, color = Red, style = MaterialTheme.typography.bodyMedium)
        }

        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { viewModel.postJob(title, category, description, skills, payMin, payMax, duration, locationType, location) },
            modifier = Modifier.fillMaxWidth().height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DeepGrey, contentColor = White),
            enabled = uiState !is PostJobUiState.Loading
        ) {
            if (uiState is PostJobUiState.Loading) {
                CircularProgressIndicator(modifier = Modifier.size(20.dp), color = White, strokeWidth = 2.dp)
            } else {
                Text("POST JOB")
            }
        }
    }
}