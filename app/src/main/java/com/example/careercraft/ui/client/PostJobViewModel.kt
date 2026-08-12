package com.example.careercraft.ui.client

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.models.JobInsert
import com.example.careercraft.data.supabase.AuthRepository
import com.example.careercraft.data.supabase.ClientRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class PostJobUiState {
    data object Idle : PostJobUiState()
    data object Loading : PostJobUiState()
    data object Success : PostJobUiState()
    data class Error(val message: String) : PostJobUiState()
}

class PostJobViewModel(
    private val clientRepository: ClientRepository = ClientRepository(),
    private val authRepository: AuthRepository = AuthRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<PostJobUiState>(PostJobUiState.Idle)
    val uiState: StateFlow<PostJobUiState> = _uiState.asStateFlow()

    fun postJob(
        title: String, category: String, description: String, skillsText: String,
        payMin: String, payMax: String, duration: String, locationType: String, location: String
    ) {
        val clientId = authRepository.currentUserId()
        val min = payMin.toDoubleOrNull()
        val max = payMax.toDoubleOrNull()
        val skills = skillsText.split(",").map { it.trim() }.filter { it.isNotBlank() }

        if (clientId == null) {
            _uiState.value = PostJobUiState.Error("Session expired. Please log in again.")
            return
        }
        if (title.isBlank() || description.length < 20 || skills.size < 3 || min == null || max == null || duration.isBlank()) {
            _uiState.value = PostJobUiState.Error("Please fill in all fields (description 20+ chars, at least 3 skills).")
            return
        }

        _uiState.value = PostJobUiState.Loading
        viewModelScope.launch {
            try {
                clientRepository.postJob(
                    JobInsert(
                        clientId = clientId, title = title, category = category, description = description,
                        requiredSkills = skills, payMin = min, payMax = max, duration = duration,
                        locationType = locationType, location = location.ifBlank { null }
                    )
                )
                _uiState.value = PostJobUiState.Success
            } catch (e: Exception) {
                _uiState.value = PostJobUiState.Error(e.message ?: "Could not post job. Please try again.")
            }
        }
    }
}