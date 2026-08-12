package com.example.careercraft.ui.contracts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.ContractRepository
import com.example.careercraft.data.supabase.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class RatingUiState {
    data object Loading : RatingUiState()
    data class Ready(val revieweeName: String, val revieweeId: String, val myId: String) : RatingUiState()
    data object Done : RatingUiState()
    data class Error(val message: String) : RatingUiState()
}

class RatingViewModel(
    private val contractId: String,
    private val contractRepository: ContractRepository = ContractRepository(),
    private val userRepository: UserRepository = UserRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<RatingUiState>(RatingUiState.Loading)
    val uiState: StateFlow<RatingUiState> = _uiState.asStateFlow()

    init { load() }

    private fun load() {
        val myId = authRepository.currentUserId()
        if (myId == null) {
            _uiState.value = RatingUiState.Error("Session expired. Please log in again.")
            return
        }
        viewModelScope.launch {
            try {
                val contract = contractRepository.getContract(contractId)
                val revieweeId = if (myId == contract.freelancerId) contract.clientId else contract.freelancerId
                val reviewee = userRepository.getProfile(revieweeId)
                _uiState.value = RatingUiState.Ready(reviewee.displayName, revieweeId, myId)
            } catch (e: Exception) {
                _uiState.value = RatingUiState.Error(e.message ?: "Could not load contract.")
            }
        }
    }

    fun submit(rating: Int, feedback: String) {
        val state = _uiState.value
        if (state !is RatingUiState.Ready) return
        viewModelScope.launch {
            try {
                contractRepository.submitReview(contractId, state.myId, state.revieweeId, rating, feedback)
                _uiState.value = RatingUiState.Done
            } catch (e: Exception) {
                _uiState.value = RatingUiState.Error(e.message ?: "Could not submit rating. Please try again.")
            }
        }
    }

    fun skip() {
        _uiState.value = RatingUiState.Done
    }
}

class RatingViewModelFactory(private val contractId: String) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = RatingViewModel(contractId) as T
}