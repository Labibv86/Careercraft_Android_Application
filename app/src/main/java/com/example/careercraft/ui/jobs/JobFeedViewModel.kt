package com.example.careercraft.ui.jobs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.models.Job
import com.example.careercraft.data.models.UserProfileData
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.JobRepository
import com.example.careercraft.data.supabase.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class JobWithClient(
    val job: Job,
    val client: UserProfileData
)

sealed class JobFeedUiState {
    data object Loading : JobFeedUiState()
    data class Ready(val jobs: List<JobWithClient>) : JobFeedUiState()
    data class Error(val message: String) : JobFeedUiState()
}

class JobFeedViewModel(
    private val jobRepository: JobRepository = JobRepository(),
    private val userRepository: UserRepository = UserRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<JobFeedUiState>(JobFeedUiState.Loading)
    val uiState: StateFlow<JobFeedUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val userId = authRepository.currentUserId()
                val preferredCategory = userId?.let {
                    val profile = userRepository.getProfile(it)
                    profile.careerPath?.substringBefore(" ") ?: profile.selectedCategories?.firstOrNull()
                }
                val appliedJobIds = userId?.let { jobRepository.getAppliedJobIds(it) } ?: emptySet()
                val openJobs = jobRepository.getOpenJobs(preferredCategory, appliedJobIds)

                // Fetch client info for each job
                val jobsWithClient = openJobs.map { job ->
                    val client = userRepository.getProfile(job.clientId)
                    JobWithClient(job, client)
                }

                _uiState.value = JobFeedUiState.Ready(jobsWithClient)
            } catch (e: Exception) {
                _uiState.value = JobFeedUiState.Error(e.message ?: "Could not load jobs.")
            }
        }
    }
}