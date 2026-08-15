package com.example.careercraft.ui.portfolio

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.PortfolioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class PortfolioFormUiState {
    data object Idle : PortfolioFormUiState()
    data object Uploading : PortfolioFormUiState()
    data object Success : PortfolioFormUiState()
    data class Error(val message: String) : PortfolioFormUiState()
}

class PortfolioFormViewModel(
    private val portfolioRepository: PortfolioRepository = PortfolioRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<PortfolioFormUiState>(PortfolioFormUiState.Idle)
    val uiState: StateFlow<PortfolioFormUiState> = _uiState.asStateFlow()

    fun submit(title: String, category: String, description: String, images: List<Pair<ByteArray, String>>) {
        val freelancerId = authRepository.currentUserId()
        if (freelancerId == null) {
            _uiState.value = PortfolioFormUiState.Error("Session expired. Please log in again.")
            return
        }
        if (title.isBlank() || images.isEmpty()) {
            _uiState.value = PortfolioFormUiState.Error("Please add a title and at least one image.")
            return
        }

        _uiState.value = PortfolioFormUiState.Uploading
        viewModelScope.launch {
            try {
                val urls = images.map { (bytes, ext) -> portfolioRepository.uploadImage(freelancerId, bytes, ext) }
                portfolioRepository.createPortfolioItem(freelancerId, title, category, description.ifBlank { null }, urls)
                _uiState.value = PortfolioFormUiState.Success
            } catch (e: Exception) {
                _uiState.value = PortfolioFormUiState.Error(e.message ?: "Could not save project. Please try again.")
            }
        }
    }
}