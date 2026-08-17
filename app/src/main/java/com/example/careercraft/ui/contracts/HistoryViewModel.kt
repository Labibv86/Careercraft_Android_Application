package com.example.careercraft.ui.contracts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.models.Job
import com.example.careercraft.data.models.ProposalDetails
import com.example.careercraft.data.models.ReviewRecord
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.ContractRepository
import com.example.careercraft.data.supabase.JobRepository
import com.example.careercraft.data.supabase.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class HistoryData(
    val job: Job,
    val proposal: ProposalDetails,
    val otherPartyId: String,
    val otherPartyName: String,
    val isFreelancer: Boolean,
    val myReview: ReviewRecord?,
    val theirReview: ReviewRecord?
)

sealed class HistoryUiState {
    data object Loading : HistoryUiState()
    data class Ready(val data: HistoryData) : HistoryUiState()
    data class Error(val message: String) : HistoryUiState()
}

class HistoryViewModel(
    private val contractId: String,
    private val contractRepository: ContractRepository = ContractRepository(),
    private val jobRepository: JobRepository = JobRepository(),
    private val userRepository: UserRepository = UserRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<HistoryUiState>(HistoryUiState.Loading)
    val uiState: StateFlow<HistoryUiState> = _uiState.asStateFlow()

    init { load() }

    private fun load() {
        val myId = authRepository.currentUserId()
        if (myId == null) {
            _uiState.value = HistoryUiState.Error("Session expired. Please log in again.")
            return
        }
        viewModelScope.launch {
            try {
                val contract = contractRepository.getContract(contractId)
                val job = jobRepository.getJob(contract.jobId)
                val proposal = contractRepository.getProposal(contract.proposalId)
                val isFreelancer = myId == contract.freelancerId
                val otherPartyId = if (isFreelancer) contract.clientId else contract.freelancerId
                val otherParty = userRepository.getProfile(otherPartyId)
                val reviews = contractRepository.getReviews(contractId)
                val myReview = reviews.find { it.reviewerId == myId }
                val theirReview = reviews.find { it.reviewerId == otherPartyId }

                _uiState.value = HistoryUiState.Ready(
                    HistoryData(job, proposal, otherPartyId, otherParty.displayName, isFreelancer, myReview, theirReview)
                )
            } catch (e: Exception) {
                _uiState.value = HistoryUiState.Error(e.message ?: "Could not load history.")
            }
        }
    }
}

class HistoryViewModelFactory(private val contractId: String) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = HistoryViewModel(contractId) as T
}