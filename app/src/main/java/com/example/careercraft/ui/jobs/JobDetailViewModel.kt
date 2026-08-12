package com.example.careercraft.ui.jobs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.models.Job
import com.example.careercraft.data.supabase.JobRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class JobDetailUiState {
    data object Loading : JobDetailUiState()
    data class Ready(val job: Job) : JobDetailUiState()
    data class Error(val message: String) : JobDetailUiState()
}

class JobDetailViewModel(
    private val jobId: String,
    private val jobRepository: JobRepository = JobRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<JobDetailUiState>(JobDetailUiState.Loading)
    val uiState: StateFlow<JobDetailUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                _uiState.value = JobDetailUiState.Ready(jobRepository.getJob(jobId))
            } catch (e: Exception) {
                _uiState.value = JobDetailUiState.Error(e.message ?: "Could not load job details.")
            }
        }
    }
}

class JobDetailViewModelFactory(private val jobId: String) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = JobDetailViewModel(jobId) as T
}