package com.example.careercraft.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.careercraft.ui.common.SelectableCard
import com.example.careercraft.ui.theme.Black
import com.example.careercraft.ui.theme.DeepGrey
import com.example.careercraft.ui.theme.Red
import com.example.careercraft.ui.theme.White

@Composable
fun CareerMatchResultsScreen(
    onAccept: () -> Unit,
    onNotSatisfied: () -> Unit,
    viewModel: CareerMatchViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {
        if (uiState is CareerMatchUiState.Saved) onAccept()
    }

    Box(
        modifier = Modifier.fillMaxSize().background(White),
        contentAlignment = Alignment.Center
    ) {
        when (val state = uiState) {
            is CareerMatchUiState.Loading -> CircularProgressIndicator(color = Black)
            is CareerMatchUiState.Saved -> CircularProgressIndicator(color = Black)
            is CareerMatchUiState.Error -> Text(state.message, color = Red, modifier = Modifier.padding(24.dp))
            is CareerMatchUiState.Ready -> {
                Column(modifier = Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.Center) {
                    Text("Your Career Matches", style = MaterialTheme.typography.titleLarge, color = Black)
                    Spacer(Modifier.height(4.dp))
                    Text(state.careerPath, style = MaterialTheme.typography.bodyMedium, color = Black)
                    Spacer(Modifier.height(20.dp))

                    state.matches.forEachIndexed { index, match ->
                        val rankEmoji = when (index) { 0 -> "\uD83E\uDD47"; 1 -> "\uD83E\uDD48"; else -> "\uD83E\uDD49" }
                        SelectableCard(
                            title = "$rankEmoji ${match.job.title} — ${match.matchPercent}% match",
                            subtitle = match.job.skills,
                            selected = false,
                            onClick = {}
                        )
                        Spacer(Modifier.height(12.dp))
                    }

                    Spacer(Modifier.height(8.dp))
                    Button(
                        onClick = { viewModel.acceptMatch() },
                        modifier = Modifier.fillMaxWidth().height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = DeepGrey, contentColor = White)
                    ) { Text("ACCEPT") }

                    Spacer(Modifier.height(12.dp))
                    TextButton(onClick = onNotSatisfied, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        Text("I'M NOT SATISFIED", color = Red)
                    }
                }
            }
        }
    }
}