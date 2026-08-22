package com.example.careercraft.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class Notification(
    @SerialName("notification_id") val notificationId: String,
    @SerialName("user_id") val userId: String,
    val type: String, // "proposal", "acceptance", "rejection", "message", "completion", "payment", "rating"
    val title: String,
    val body: String,
    val data: JsonObject? = null,
    @SerialName("read") val read: Boolean = false,
    @SerialName("created_at") val createdAt: String
)

@Serializable
data class NotificationInsert(
    @SerialName("user_id") val userId: String,
    val type: String,
    val title: String,
    val body: String,
    val data: JsonObject? = null
)