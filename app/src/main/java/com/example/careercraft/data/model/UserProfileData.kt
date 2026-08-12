package com.example.careercraft.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserProfileData(
    @SerialName("user_id") val userId: String,
    @SerialName("display_name") val displayName: String,
    val role: String,
    @SerialName("career_path") val careerPath: String? = null,
    @SerialName("rating_score") val ratingScore: Double = 0.0,
    @SerialName("total_reviews") val totalReviews: Int = 0,
    @SerialName("profile_percent") val profilePercent: Int = 0,
    @SerialName("selected_categories") val selectedCategories: List<String>? = null
)