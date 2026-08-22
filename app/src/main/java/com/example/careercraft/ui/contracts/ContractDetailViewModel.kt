package com.example.careercraft.ui.contracts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.models.Contract
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.ContractRepository
import com.example.careercraft.data.supabase.JobRepository
import com.example.careercraft.data.supabase.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class ContractDetailData(
    val contract: Contract,
    val jobTitle: String,
    val otherPartyName: String,
    val otherPartyPhotoUrl: String?,  // ADD THIS
    val otherPartyRating: Double,
    val otherPartyId: String,  // ADD THIS
    val isFreelancer: Boolean,
    val myPartComplete: Boolean
)

sealed class ContractDetailUiState {
    data object Loading : ContractDetailUiState()
    data class Ready(val data: ContractDetailData) : ContractDetailUiState()
    data class NeedsRating(val contractId: String) : ContractDetailUiState()
    data class ShowHistory(val contractId: String) : ContractDetailUiState()
    data class Error(val message: String) : ContractDetailUiState()
}

class ContractDetailViewModel(
    private val contractId: String,
    private val contractRepository: ContractRepository = ContractRepository(),
    private val jobRepository: JobRepository = JobRepository(),
    private val userRepository: UserRepository = UserRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<ContractDetailUiState>(ContractDetailUiState.Loading)
    val uiState: StateFlow<ContractDetailUiState> = _uiState.asStateFlow()

    init { load() }

    private fun load() {
        val myId = authRepository.currentUserId()
        if (myId == null) {
            _uiState.value = ContractDetailUiState.Error("Session expired. Please log in again.")
            return
        }
        viewModelScope.launch {
            try {
                val contract = contractRepository.getContract(contractId)

                if (contract.status == "completed") {
                    val alreadyReviewed = contractRepository.hasReviewed(contractId, myId)
                    _uiState.value = if (alreadyReviewed) {
                        ContractDetailUiState.ShowHistory(contractId)
                    } else {
                        ContractDetailUiState.NeedsRating(contractId)
                    }
                    return@launch
                }

                val job = jobRepository.getJob(contract.jobId)
                val isFreelancer = myId == contract.freelancerId
                val otherPartyId = if (isFreelancer) contract.clientId else contract.freelancerId
                val otherParty = userRepository.getProfile(otherPartyId)
                val myPartComplete = if (isFreelancer) contract.freelancerCompleted else contract.clientCompleted

                _uiState.value = ContractDetailUiState.Ready(
                    ContractDetailData(
                        contract = contract,
                        jobTitle = job.title,
                        otherPartyName = otherParty.displayName,
                        otherPartyPhotoUrl = otherParty.photoUrl,  // ADD THIS
                        otherPartyRating = otherParty.ratingScore,
                        otherPartyId = otherPartyId,  // ADD THIS
                        isFreelancer = isFreelancer,
                        myPartComplete = myPartComplete
                    )
                )
            } catch (e: Exception) {
                _uiState.value = ContractDetailUiState.Error(e.message ?: "Could not load contract.")
            }
        }
    }

    fun markComplete() {
        val state = _uiState.value
        if (state !is ContractDetailUiState.Ready) return
        viewModelScope.launch {
            try {
                contractRepository.markComplete(contractId, state.data.isFreelancer)
                load()
            } catch (e: Exception) {
                _uiState.value = ContractDetailUiState.Error(e.message ?: "Could not update contract.")
            }
        }
    }
}

class ContractDetailViewModelFactory(private val contractId: String) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = ContractDetailViewModel(contractId) as T
}