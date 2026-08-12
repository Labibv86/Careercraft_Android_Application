package com.example.careercraft.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.models.AssessmentQuestion
import com.example.careercraft.data.supabase.AssessmentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class AssessmentUiState {
    data object Loading : AssessmentUiState()
    data class InProgress(val questions: List<AssessmentQuestion>, val currentIndex: Int) : AssessmentUiState()
    data object Finished : AssessmentUiState()
    data class Error(val message: String) : AssessmentUiState()
}

class SkillAssessmentViewModel(
    private val repository: AssessmentRepository = AssessmentRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<AssessmentUiState>(AssessmentUiState.Loading)
    val uiState: StateFlow<AssessmentUiState> = _uiState.asStateFlow()

    init {
        loadQuestions()
    }

    private fun loadQuestions() {
        viewModelScope.launch {
            try {
                val questions = repository.getQuestions()
                AssessmentAnswers.clear()
                _uiState.value = AssessmentUiState.InProgress(questions, currentIndex = 0)
            } catch (e: Exception) {
                _uiState.value = AssessmentUiState.Error(e.message ?: "Could not load the assessment. Please try again.")
            }
        }
    }

    fun answerAndAdvance(featureMapping: String, value: Any) {
        AssessmentAnswers.values[featureMapping] = value
        val state = _uiState.value
        if (state is AssessmentUiState.InProgress) {
            val nextIndex = state.currentIndex + 1
            _uiState.value = if (nextIndex >= state.questions.size) {
                AssessmentUiState.Finished
            } else {
                state.copy(currentIndex = nextIndex)
            }
        }
    }

    fun skipAndAdvance() {
        val state = _uiState.value
        if (state is AssessmentUiState.InProgress) {
            answerAndAdvance(state.questions[state.currentIndex].featureMapping, "neutral")
        }
    }
}