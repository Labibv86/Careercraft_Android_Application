package com.example.careercraft.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategorySelectionUpdate(
    @SerialName("selected_categories") val selectedCategories: List<String>,
    @SerialName("profile_complete") val profileComplete: Boolean = true,
    @SerialName("profile_percent") val profilePercent: Int = 100
)