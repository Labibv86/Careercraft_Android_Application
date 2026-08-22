package com.example.careercraft.ui.client

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.models.UserProfileData
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.ClientRepository
import com.example.careercraft.data.supabase.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class ClientDashboardData(
    val profile: UserProfileData,
    val activeJobs: Int,
    val applicationsReceived: Int,
    val activeContracts: Int
)

sealed class ClientDashboardUiState {
    data object Loading : ClientDashboardUiState()
    data class Ready(val data: ClientDashboardData) : ClientDashboardUiState()
    data class Error(val message: String) : ClientDashboardUiState()
}

class ClientDashboardViewModel(
    private val userRepository: UserRepository = UserRepository(),
    private val clientRepository: ClientRepository = ClientRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<ClientDashboardUiState>(ClientDashboardUiState.Loading)
    val uiState: StateFlow<ClientDashboardUiState> = _uiState.asStateFlow()

    init { load() }

    fun refresh() = load()

    fun load() {

        val userId = authRepository.currentUserId()
        if (userId == null) {
            _uiState.value = ClientDashboardUiState.Error("Session expired. Please log in again.")
            return
        }
        viewModelScope.launch {
            try {
                val profile = userRepository.getProfile(userId)
                val jobs = clientRepository.getMyJobs(userId)
                _uiState.value = ClientDashboardUiState.Ready(
                    ClientDashboardData(
                        profile = profile,
                        activeJobs = jobs.count { it.status == "open" || it.status == "in-progress" },
                        applicationsReceived = jobs.sumOf { it.pendingApplicants },
                        activeContracts = jobs.count { it.status == "in-progress" }
                    )
                )
            } catch (e: Exception) {
                _uiState.value = ClientDashboardUiState.Error(e.message ?: "Could not load dashboard.")
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