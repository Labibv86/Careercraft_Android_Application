package com.example.careercraft.ui.contracts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.models.ChatMessage
import com.example.careercraft.data.models.Contract
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.ContractRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class ChatUiState {
    data object Loading : ChatUiState()
    data class Ready(val contract: Contract, val messages: List<ChatMessage>, val myId: String) : ChatUiState()
    data class Error(val message: String) : ChatUiState()
}

class ChatViewModel(
    private val contractId: String,
    private val contractRepository: ContractRepository = ContractRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<ChatUiState>(ChatUiState.Loading)
    val uiState: StateFlow<ChatUiState> = _uiState.asStateFlow()

    init { load() }

    private fun load() {
        val myId = authRepository.currentUserId()
        if (myId == null) {
            _uiState.value = ChatUiState.Error("Session expired. Please log in again.")
            return
        }
        viewModelScope.launch {
            try {
                val contract = contractRepository.getContract(contractId)
                val messages = contractRepository.getMessages(contractId)
                _uiState.value = ChatUiState.Ready(contract, messages, myId)
            } catch (e: Exception) {
                _uiState.value = ChatUiState.Error(e.message ?: "Could not load chat.")
            }
        }
    }

    fun sendMessage(content: String) {
        val state = _uiState.value
        if (state !is ChatUiState.Ready || content.isBlank()) return
        val receiverId = if (state.myId == state.contract.freelancerId) state.contract.clientId else state.contract.freelancerId
        viewModelScope.launch {
            try {
                contractRepository.sendMessage(contractId, state.myId, receiverId, content)
                load()
            } catch (_: Exception) {
                // existing messages stay visible; user can just retry sending
            }
        }
    }
}

class ChatViewModelFactory(private val contractId: String) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = ChatViewModel(contractId) as T
}