package com.example.careercraft.ui.jobs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.ContractRepository
import com.example.careercraft.data.supabase.JobRepository
import com.example.careercraft.data.supabase.UserRepository
import com.example.careercraft.util.isPastDeadline
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

enum class WorkStatus { ONGOING, OVERDUE, FINISHED }

data class FreelancerJobItem(
    val contractId: String,
    val jobTitle: String,
    val clientName: String,
    val workStatus: WorkStatus
)

sealed class FreelancerJobsUiState {
    data object Loading : FreelancerJobsUiState()
    data class Ready(val jobs: List<FreelancerJobItem>) : FreelancerJobsUiState()
    data class Error(val message: String) : FreelancerJobsUiState()
}

class FreelancerJobsViewModel(
    private val contractRepository: ContractRepository = ContractRepository(),
    private val jobRepository: JobRepository = JobRepository(),
    private val userRepository: UserRepository = UserRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<FreelancerJobsUiState>(FreelancerJobsUiState.Loading)
    val uiState: StateFlow<FreelancerJobsUiState> = _uiState.asStateFlow()

    init { load() }

    fun refresh() = load()

    private fun load() {
        val freelancerId = authRepository.currentUserId()
        if (freelancerId == null) {
            _uiState.value = FreelancerJobsUiState.Error("Session expired. Please log in again.")
            return
        }
        viewModelScope.launch {
            try {
                val contracts = contractRepository.getContractsForFreelancer(freelancerId)
                val items = contracts.map { contract ->
                    val job = jobRepository.getJob(contract.jobId)
                    val client = userRepository.getProfile(contract.clientId)
                    val workStatus = when {
                        contract.status == "completed" -> WorkStatus.FINISHED
                        isPastDeadline(job.deadline) -> WorkStatus.OVERDUE
                        else -> WorkStatus.ONGOING
                    }
                    FreelancerJobItem(contract.contractId, job.title, client.displayName, workStatus)
                }
                val sorted = items.sortedBy { it.workStatus.ordinal } // ONGOING(0) -> OVERDUE(1) -> FINISHED(2)
                _uiState.value = FreelancerJobsUiState.Ready(sorted)
            } catch (e: Exception) {
                _uiState.value = FreelancerJobsUiState.Error(e.message ?: "Could not load your jobs.")
            }
        }
    }
}