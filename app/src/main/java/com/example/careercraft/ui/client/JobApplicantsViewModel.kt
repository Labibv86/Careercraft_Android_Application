package com.example.careercraft.ui.client

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.models.ProposalWithFreelancer
import com.example.careercraft.data.supabase.ClientRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class JobApplicantsUiState {
    data object Loading : JobApplicantsUiState()
    data class Ready(val applicants: List<ProposalWithFreelancer>) : JobApplicantsUiState()
    data class Hired(val contractId: String) : JobApplicantsUiState()
    data class Error(val message: String) : JobApplicantsUiState()
}

class JobApplicantsViewModel(
    private val jobId: String,
    private val clientRepository: ClientRepository = ClientRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<JobApplicantsUiState>(JobApplicantsUiState.Loading)
    val uiState: StateFlow<JobApplicantsUiState> = _uiState.asStateFlow()

    init { load() }

    private fun load() {
        viewModelScope.launch {
            try {
                _uiState.value = JobApplicantsUiState.Ready(clientRepository.getApplicants(jobId))
            } catch (e: Exception) {
                _uiState.value = JobApplicantsUiState.Error(e.message ?: "Could not load applicants.")
            }
        }
    }

    fun hire(proposalId: String) {
        viewModelScope.launch {
            try {
                val contractId = clientRepository.hireFreelancer(proposalId)
                _uiState.value = JobApplicantsUiState.Hired(contractId)
            } catch (e: Exception) {
                _uiState.value = JobApplicantsUiState.Error(e.message ?: "Could not hire this freelancer.")
            }
        }
    }
}

class JobApplicantsViewModelFactory(private val jobId: String) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = JobApplicantsViewModel(jobId) as T
}