package com.example.careercraft.ui.jobs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.JobRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class ProposalUiState {
    data object Idle : ProposalUiState()
    data object Loading : ProposalUiState()
    data object Success : ProposalUiState()
    data class Error(val message: String) : ProposalUiState()
}

class ProposalFormViewModel(
    private val jobId: String,
    private val jobRepository: JobRepository = JobRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProposalUiState>(ProposalUiState.Idle)
    val uiState: StateFlow<ProposalUiState> = _uiState.asStateFlow()

    fun submit(coverLetter: String, proposedRate: String, estimatedTimeline: String) {
        val freelancerId = authRepository.currentUserId()
        val rate = proposedRate.toDoubleOrNull()
        if (freelancerId == null) {
            _uiState.value = ProposalUiState.Error("Session expired. Please log in again.")
            return
        }
        if (coverLetter.isBlank() || rate == null || estimatedTimeline.isBlank()) {
            _uiState.value = ProposalUiState.Error("Please fill in all fields with a valid rate.")
            return
        }

        _uiState.value = ProposalUiState.Loading
        viewModelScope.launch {
            try {
                jobRepository.submitProposal(jobId, freelancerId, coverLetter, rate, estimatedTimeline)
                _uiState.value = ProposalUiState.Success
            } catch (e: Exception) {
                val message = if (e.message?.contains("duplicate key", ignoreCase = true) == true) {
                    "You've already applied to this job."
                } else {
                    e.message ?: "Could not submit proposal. Please try again."
                }
                _uiState.value = ProposalUiState.Error(message)
            }
        }
    }
}

class ProposalFormViewModelFactory(private val jobId: String) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = ProposalFormViewModel(jobId) as T
}