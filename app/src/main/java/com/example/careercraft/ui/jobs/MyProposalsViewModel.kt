package com.example.careercraft.ui.jobs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.models.ProposalWithJob
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.JobRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class MyProposalsUiState {
    data object Loading : MyProposalsUiState()
    data class Ready(val proposals: List<ProposalWithJob>) : MyProposalsUiState()
    data class Error(val message: String) : MyProposalsUiState()
}

class MyProposalsViewModel(
    private val jobRepository: JobRepository = JobRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<MyProposalsUiState>(MyProposalsUiState.Loading)
    val uiState: StateFlow<MyProposalsUiState> = _uiState.asStateFlow()

    init { load() }

    private fun load() {
        val freelancerId = authRepository.currentUserId()
        if (freelancerId == null) {
            _uiState.value = MyProposalsUiState.Error("Session expired. Please log in again.")
            return
        }
        viewModelScope.launch {
            try {
                _uiState.value = MyProposalsUiState.Ready(jobRepository.getMyProposals(freelancerId))
            } catch (e: Exception) {
                _uiState.value = MyProposalsUiState.Error(e.message ?: "Could not load proposals.")
            }
        }
    }

    fun withdraw(proposalId: String) {
        viewModelScope.launch {
            try {
                jobRepository.withdrawProposal(proposalId)
                load()
            } catch (_: Exception) {
                // silently ignore; list simply won't update, user can retry
            }
        }
    }
}