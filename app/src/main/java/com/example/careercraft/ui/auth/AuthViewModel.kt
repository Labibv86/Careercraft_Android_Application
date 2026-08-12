package com.example.careercraft.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.supabase.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class AuthUiState {
    data object Idle : AuthUiState()
    data object Loading : AuthUiState()
    data object Success : AuthUiState()
    data class Error(val message: String) : AuthUiState()
}

class AuthViewModel(
    private val repository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<AuthUiState>(AuthUiState.Idle)
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun login(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            _uiState.value = AuthUiState.Error("Please fill in both fields.")
            return
        }
        _uiState.value = AuthUiState.Loading
        viewModelScope.launch {
            try {
                repository.signIn(email, password)
                _uiState.value = AuthUiState.Success
            } catch (e: Exception) {
                _uiState.value = AuthUiState.Error(e.message ?: "Login failed. Please try again.")
            }
        }
    }

    fun signUp(fullName: String, email: String, password: String, confirmPassword: String) {
        if (fullName.isBlank() || email.isBlank() || password.isBlank()) {
            _uiState.value = AuthUiState.Error("Please fill in all fields.")
            return
        }
        if (password != confirmPassword) {
            _uiState.value = AuthUiState.Error("Passwords do not match.")
            return
        }
        if (password.length < 8) {
            _uiState.value = AuthUiState.Error("Password must be at least 8 characters.")
            return
        }
        _uiState.value = AuthUiState.Loading
        viewModelScope.launch {
            try {
                repository.signUp(email, password, fullName)
                _uiState.value = AuthUiState.Success
            } catch (e: Exception) {
                _uiState.value = AuthUiState.Error(e.message ?: "Sign up failed. Please try again.")
            }
        }
    }

    fun resetState() {
        _uiState.value = AuthUiState.Idle
    }
}