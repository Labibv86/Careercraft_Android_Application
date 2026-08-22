package com.example.careercraft.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class ProfileUiState {
    data object Idle : ProfileUiState()
    data object Loading : ProfileUiState()
    data object Success : ProfileUiState()
    data class Error(val message: String) : ProfileUiState()
}

class OnboardingViewModel(
    private val userRepository: UserRepository = UserRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Idle)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    fun createProfile(role: String, userType: String) {
        val userId = authRepository.currentUserId()
        val email = authRepository.currentUserEmail()
        val displayName = authRepository.currentUserFullName() ?: email ?: "New User"

        if (userId == null || email == null) {
            _uiState.value = ProfileUiState.Error("Session expired. Please log in again.")
            return
        }

        _uiState.value = ProfileUiState.Loading
        viewModelScope.launch {
            try {
                userRepository.createProfile(userId, email, displayName, role, userType)
                _uiState.value = ProfileUiState.Success
            } catch (e: Exception) {
                _uiState.value = ProfileUiState.Error(e.message ?: "Could not save profile. Please try again.")
            }
        }
    }

    fun resetState() {
        _uiState.value = ProfileUiState.Idle
    }

    fun saveCategories(categories: List<String>) {
        val userId = authRepository.currentUserId()
        if (userId == null) {
            _uiState.value = ProfileUiState.Error("Session expired. Please log in again.")
            return
        }
        val displayNames = mapOf(
            "Technology" to "Technology & Remote Work",
            "Creative" to "Creative & Design",
            "Physical" to "Physical & Labor",
            "Service" to "Service & Public Facing"
        )
        val careerPath = categories.mapNotNull { displayNames[it] }.joinToString(", ")

        _uiState.value = ProfileUiState.Loading
        viewModelScope.launch {
            try {
                userRepository.updateCategories(userId, categories, careerPath)
                _uiState.value = ProfileUiState.Success
            } catch (e: Exception) {
                _uiState.value = ProfileUiState.Error(e.message ?: "Could not save categories. Please try again.")
            }
        }
    }
}