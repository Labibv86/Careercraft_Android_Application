package com.example.careercraft.ui.contracts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.ContractRepository
import com.example.careercraft.data.supabase.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class ChatListItem(
    val contractId: String,
    val otherPartyName: String,
    val otherPartyPhotoUrl: String?,  // ADD THIS
    val preview: String
)

sealed class ChatListUiState {
    data object Loading : ChatListUiState()
    data class Ready(val chats: List<ChatListItem>) : ChatListUiState()
    data class Error(val message: String) : ChatListUiState()
}

class ChatListViewModel(
    private val contractRepository: ContractRepository = ContractRepository(),
    private val userRepository: UserRepository = UserRepository(),  // ADD THIS
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<ChatListUiState>(ChatListUiState.Loading)
    val uiState: StateFlow<ChatListUiState> = _uiState.asStateFlow()

    init { load() }

    private fun load() {
        val myId = authRepository.currentUserId()
        if (myId == null) {
            _uiState.value = ChatListUiState.Error("Session expired. Please log in again.")
            return
        }
        viewModelScope.launch {
            try {
                val contracts = contractRepository.getMyContracts(myId)
                val items = contracts.map { contract ->
                    val otherPartyId = if (myId == contract.freelancerId) contract.clientId else contract.freelancerId
                    val otherParty = userRepository.getProfile(otherPartyId)
                    val lastMessage = contractRepository.getLastMessage(contract.contractId)
                    val preview = lastMessage?.content ?: "You're now connected — start chatting!"

                    ChatListItem(
                        contractId = contract.contractId,
                        otherPartyName = otherParty.displayName,
                        otherPartyPhotoUrl = otherParty.photoUrl,  // ADD THIS
                        preview = preview
                    )
                }
                _uiState.value = ChatListUiState.Ready(items)
            } catch (e: Exception) {
                _uiState.value = ChatListUiState.Error(e.message ?: "Could not load chats.")
            }
        }
    }
}