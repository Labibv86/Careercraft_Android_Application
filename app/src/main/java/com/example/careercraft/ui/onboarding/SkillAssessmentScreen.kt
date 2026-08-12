package com.example.careercraft.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.careercraft.ui.theme.Black
import com.example.careercraft.ui.theme.DeepGrey
import com.example.careercraft.ui.theme.Grey
import com.example.careercraft.ui.theme.LightGrey
import com.example.careercraft.ui.theme.Red
import com.example.careercraft.ui.theme.White

@Composable
fun SkillAssessmentScreen(
    onFinished: () -> Unit,
    viewModel: SkillAssessmentViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {
        if (uiState is AssessmentUiState.Finished) {
            onFinished()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        contentAlignment = Alignment.Center
    ) {
        when (val state = uiState) {
            is AssessmentUiState.Loading -> CircularProgressIndicator(color = Black)
            is AssessmentUiState.Finished -> CircularProgressIndicator(color = Black)
            is AssessmentUiState.Error -> Text(state.message, color = Red, modifier = Modifier.padding(24.dp))
            is AssessmentUiState.InProgress -> {
                val question = state.questions[state.currentIndex]
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Question ${state.currentIndex + 1} of ${state.questions.size}",
                        color = Grey,
                        style = MaterialTheme.typography.labelSmall
                    )
                    Spacer(Modifier.height(24.dp))
                    Text(question.question, style = MaterialTheme.typography.titleMedium, color = Black)
                    Spacer(Modifier.height(24.dp))

                    if (question.type == "slider") {
                        var sliderValue by remember(question.questionId) {
                            mutableFloatStateOf(((question.minValue ?: 1) + (question.maxValue ?: 10)) / 2f)
                        }
                        Slider(
                            value = sliderValue,
                            onValueChange = { sliderValue = it },
                            valueRange = (question.minValue ?: 1).toFloat()..(question.maxValue ?: 10).toFloat(),
                            steps = ((question.maxValue ?: 10) - (question.minValue ?: 1) - 1).coerceAtLeast(0),
                            colors = SliderDefaults.colors(thumbColor = DeepGrey, activeTrackColor = DeepGrey)
                        )
                        Text("${sliderValue.toInt()}", color = Black, style = MaterialTheme.typography.bodyMedium)
                        Spacer(Modifier.height(24.dp))
                        Button(
                            onClick = { viewModel.answerAndAdvance(question.featureMapping, sliderValue.toInt()) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = DeepGrey, contentColor = White)
                        ) { Text("Next") }
                    } else {
                        (question.options ?: emptyList()).forEach { option ->
                            Button(
                                onClick = { viewModel.answerAndAdvance(question.featureMapping, option) },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                                    .height(44.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = LightGrey, contentColor = Black)
                            ) { Text(option) }
                        }
                    }

                    Spacer(Modifier.height(12.dp))
                    TextButton(onClick = { viewModel.skipAndAdvance() }) {
                        Text("Skip", color = Grey)
                    }
                }
            }
        }
    }
}