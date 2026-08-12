package com.example.careercraft.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Contract(
    @SerialName("contract_id") val contractId: String,
    @SerialName("job_id") val jobId: String,
    @SerialName("freelancer_id") val freelancerId: String,
    @SerialName("client_id") val clientId: String,
    val status: String,
    val duration: String,
    @SerialName("pay_amount") val payAmount: Double,
    @SerialName("freelancer_completed") val freelancerCompleted: Boolean,
    @SerialName("client_completed") val clientCompleted: Boolean,
    @SerialName("chat_active") val chatActive: Boolean
)

@Serializable
data class ChatMessage(
    @SerialName("message_id") val messageId: String,
    @SerialName("contract_id") val contractId: String,
    @SerialName("sender_id") val senderId: String,
    @SerialName("receiver_id") val receiverId: String,
    val content: String,
    @SerialName("created_at") val createdAt: String
)

@Serializable
data class MessageInsert(
    @SerialName("contract_id") val contractId: String,
    @SerialName("sender_id") val senderId: String,
    @SerialName("receiver_id") val receiverId: String,
    val content: String
)

@Serializable
data class CompleteContractParams(@SerialName("contract_id_param") val contractId: String)


@Serializable
data class ReviewInsert(
    @SerialName("contract_id") val contractId: String,
    @SerialName("reviewer_id") val reviewerId: String,
    @SerialName("reviewee_id") val revieweeId: String,
    val rating: Int,
    val feedback: String? = null
)
@Serializable
data class ContractRef(@SerialName("contract_id") val contractId: String)