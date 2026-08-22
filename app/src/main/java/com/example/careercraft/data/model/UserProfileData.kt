package com.example.careercraft.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserProfileData(
    @SerialName("user_id") val userId: String,
    @SerialName("display_name") val displayName: String,
    val role: String,
    @SerialName("user_type") val userType: String? = null,  // ADD THIS
    @SerialName("bio") val bio: String? = null,  // ADD THIS
    @SerialName("skills") val skills: List<String>? = null,  // ADD THIS
    @SerialName("career_path") val careerPath: String? = null,
    @SerialName("rating_score") val ratingScore: Double = 0.0,
    @SerialName("total_reviews") val totalReviews: Int = 0,
    @SerialName("profile_percent") val profilePercent: Int = 0,
    @SerialName("selected_categories") val selectedCategories: List<String>? = null,
    @SerialName("photo_url") val photoUrl: String? = null,
    @SerialName("email") val email: String? = null  // ADD THIS
)