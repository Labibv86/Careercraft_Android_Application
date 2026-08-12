package com.example.careercraft.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategorySelectionUpdate(
    @SerialName("selected_categories") val selectedCategories: List<String>,
    @SerialName("profile_complete") val profileComplete: Boolean = true,
    @SerialName("profile_percent") val profilePercent: Int = 100

)
@Serializable
data class CareerMatchUpdate(
    @SerialName("predicted_class") val predictedClass: Int,
    @SerialName("career_path") val careerPath: String,
    @SerialName("assessment_completed") val assessmentCompleted: Boolean = true,
    @SerialName("profile_complete") val profileComplete: Boolean = true,
    @SerialName("profile_percent") val profilePercent: Int = 100
)