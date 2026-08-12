package com.example.careercraft.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AssessmentQuestion(
    @SerialName("question_id") val questionId: Int,
    val question: String,
    val type: String, // "slider" or "multiple_choice"
    @SerialName("min_value") val minValue: Int? = null,
    @SerialName("max_value") val maxValue: Int? = null,
    @SerialName("feature_mapping") val featureMapping: String,
    val icon: String? = null,
    val options: List<String>? = null,
    @SerialName("display_order") val displayOrder: Int
)