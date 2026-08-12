package com.example.careercraft.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserProfileInsert(
    @SerialName("user_id") val userId: String,
    val email: String,
    @SerialName("display_name") val displayName: String,
    val role: String,
    @SerialName("user_type") val userType: String
)