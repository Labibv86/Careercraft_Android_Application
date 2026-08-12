package com.example.careercraft.ui.client

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.models.JobWithApplicantCounts
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.ClientRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class MyJobsUiState {
    data object Loading : MyJobsUiState()
    data class Ready(val jobs: List<JobWithApplicantCounts>) : MyJobsUiState()
    data class Error(val message: String) : MyJobsUiState()
}

class MyJobsViewModel(
    private val clientRepository: ClientRepository = ClientRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<MyJobsUiState>(MyJobsUiState.Loading)
    val uiState: StateFlow<MyJobsUiState> = _uiState.asStateFlow()

    init {
        val clientId = authRepository.currentUserId()
        if (clientId == null) {
            _uiState.value = MyJobsUiState.Error("Session expired. Please log in again.")
        } else {
            viewModelScope.launch {
                try {
                    _uiState.value = MyJobsUiState.Ready(clientRepository.getMyJobs(clientId))
                } catch (e: Exception) {
                    _uiState.value = MyJobsUiState.Error(e.message ?: "Could not load jobs.")
                }
            }
        }
    }
}