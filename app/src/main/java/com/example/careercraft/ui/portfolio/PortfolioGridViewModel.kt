package com.example.careercraft.ui.portfolio

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.models.PortfolioItem
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.PortfolioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class PortfolioGridUiState {
    data object Loading : PortfolioGridUiState()
    data class Ready(val items: List<PortfolioItem>) : PortfolioGridUiState()
    data class Error(val message: String) : PortfolioGridUiState()
}

class PortfolioGridViewModel(
    private val portfolioRepository: PortfolioRepository = PortfolioRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<PortfolioGridUiState>(PortfolioGridUiState.Loading)
    val uiState: StateFlow<PortfolioGridUiState> = _uiState.asStateFlow()

    init { load() }

    fun refresh() = load()

    private fun load() {
        val freelancerId = authRepository.currentUserId()
        if (freelancerId == null) {
            _uiState.value = PortfolioGridUiState.Error("Session expired. Please log in again.")
            return
        }
        viewModelScope.launch {
            try {
                _uiState.value = PortfolioGridUiState.Ready(portfolioRepository.getMyPortfolio(freelancerId))
            } catch (e: Exception) {
                _uiState.value = PortfolioGridUiState.Error(e.message ?: "Could not load portfolio.")
            }
        }
    }

    fun delete(portfolioId: String) {
        viewModelScope.launch {
            try {
                portfolioRepository.deletePortfolioItem(portfolioId)
                load()
            } catch (_: Exception) {
                // list simply won't update; user can retry
            }
        }
    }
}