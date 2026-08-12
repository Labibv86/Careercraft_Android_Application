package com.example.careercraft.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.UserRepository
import com.example.careercraft.ml.CareerModel
import com.example.careercraft.ml.FeatureVectorBuilder
import com.example.careercraft.ml.JobCatalog
import com.example.careercraft.ml.JobSuggestion
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class JobMatch(val job: JobSuggestion, val matchPercent: Int)

sealed class CareerMatchUiState {
    data object Loading : CareerMatchUiState()
    data class Ready(val careerPath: String, val matches: List<JobMatch>, val predictedClass: Int) : CareerMatchUiState()
    data object Saved : CareerMatchUiState()
    data class Error(val message: String) : CareerMatchUiState()
}

class CareerMatchViewModel(
    private val userRepository: UserRepository = UserRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<CareerMatchUiState>(CareerMatchUiState.Loading)
    val uiState: StateFlow<CareerMatchUiState> = _uiState.asStateFlow()

    init {
        runPrediction()
    }

    private fun runPrediction() {
        val vector = FeatureVectorBuilder.build(AssessmentAnswers.values)
        val probabilities = CareerModel.score(vector) // [P(Technology), P(Creative), P(Physical), P(Service)]
        val predictedClass = probabilities.indices.maxByOrNull { probabilities[it] } ?: 0
        val topProb = (probabilities[predictedClass] * 100).toInt().coerceIn(0, 100)

        val jobs = JobCatalog.jobsFor(predictedClass).take(3)
        val matches = jobs.mapIndexed { index, job ->
            JobMatch(job, (topProb - index * 7).coerceIn(50, 100))
        }
        _uiState.value = CareerMatchUiState.Ready(JobCatalog.nameFor(predictedClass), matches, predictedClass)
    }

    fun acceptMatch() {
        val state = _uiState.value
        if (state !is CareerMatchUiState.Ready) return
        val userId = authRepository.currentUserId()
        if (userId == null) {
            _uiState.value = CareerMatchUiState.Error("Session expired. Please log in again.")
            return
        }
        viewModelScope.launch {
            try {
                userRepository.saveCareerMatch(userId, state.predictedClass, state.careerPath)
                AssessmentAnswers.clear()
                _uiState.value = CareerMatchUiState.Saved
            } catch (e: Exception) {
                _uiState.value = CareerMatchUiState.Error(e.message ?: "Could not save your career path. Please try again.")
            }
        }
    }
}