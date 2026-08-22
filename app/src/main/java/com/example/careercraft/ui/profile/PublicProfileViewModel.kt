package com.example.careercraft.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.careercraft.data.models.PortfolioItem
import com.example.careercraft.data.models.ReviewRecord
import com.example.careercraft.data.models.UserProfileData
import com.example.careercraft.data.supabase.ContractRepository
import com.example.careercraft.data.supabase.PortfolioRepository
import com.example.careercraft.data.supabase.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class ReviewWithReviewer(
    val review: ReviewRecord,
    val reviewerName: String,
    val reviewerPhotoUrl: String?
)

data class PublicProfileData(
    val user: UserProfileData,
    val portfolio: List<PortfolioItem>,
    val reviews: List<ReviewWithReviewer>,
    val completedContracts: Int
)

sealed class PublicProfileUiState {
    data object Loading : PublicProfileUiState()
    data class Ready(val data: PublicProfileData) : PublicProfileUiState()
    data class Error(val message: String) : PublicProfileUiState()
}

class PublicProfileViewModel(
    private val userId: String,
    private val userRepository: UserRepository = UserRepository(),
    private val portfolioRepository: PortfolioRepository = PortfolioRepository(),
    private val contractRepository: ContractRepository = ContractRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<PublicProfileUiState>(PublicProfileUiState.Loading)
    val uiState: StateFlow<PublicProfileUiState> = _uiState.asStateFlow()

    init {
        loadProfile()
    }

    private fun loadProfile() {
        viewModelScope.launch {
            try {
                val user = userRepository.getProfile(userId)
                val portfolio = portfolioRepository.getMyPortfolio(userId)

                // Get completed contracts and their reviews
                val contracts = contractRepository.getContractsForFreelancer(userId)
                val completedContracts = contracts.count { it.status == "completed" }

                // Get all reviews for this user with reviewer names
                val reviewsWithReviewer = mutableListOf<ReviewWithReviewer>()
                contracts.forEach { contract ->
                    try {
                        val reviews = contractRepository.getReviews(contract.contractId)
                        reviews.forEach { review ->
                            // Fetch reviewer profile
                            val reviewer = userRepository.getProfile(review.reviewerId)
                            reviewsWithReviewer.add(
                                ReviewWithReviewer(
                                    review = review,
                                    reviewerName = reviewer.displayName,
                                    reviewerPhotoUrl = reviewer.photoUrl
                                )
                            )
                        }
                    } catch (_: Exception) {
                        // Skip if can't get reviews for a contract
                    }
                }

                _uiState.value = PublicProfileUiState.Ready(
                    PublicProfileData(
                        user = user,
                        portfolio = portfolio,
                        reviews = reviewsWithReviewer,
                        completedContracts = completedContracts
                    )
                )
            } catch (e: Exception) {
                _uiState.value = PublicProfileUiState.Error(e.message ?: "Could not load profile.")
            }
        }
    }
}

class PublicProfileViewModelFactory(private val userId: String) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = PublicProfileViewModel(userId) as T
}