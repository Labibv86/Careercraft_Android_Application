package com.example.careercraft.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.models.UserProfileData
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class DashboardUiState {
    data object Loading : DashboardUiState()
    data class Ready(val profile: UserProfileData) : DashboardUiState()
    data class Error(val message: String) : DashboardUiState()
}

class DashboardViewModel(
    private val userRepository: UserRepository = UserRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<DashboardUiState>(DashboardUiState.Loading)
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    init {
        loadProfile()
    }

    private fun loadProfile() {
        val userId = authRepository.currentUserId()
        if (userId == null) {
            _uiState.value = DashboardUiState.Error("Session expired. Please log in again.")
            return
        }
        viewModelScope.launch {
            try {
                val profile = userRepository.getProfile(userId)
                _uiState.value = DashboardUiState.Ready(profile)
            } catch (e: Exception) {
                _uiState.value = DashboardUiState.Error(e.message ?: "Could not load your profile.")
            }
        }
    }

    fun signOut(onSignedOut: () -> Unit) {
        viewModelScope.launch {
            authRepository.signOut()
            onSignedOut()
        }
    }
}