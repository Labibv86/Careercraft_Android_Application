package com.example.careercraft.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Job(
    @SerialName("job_id") val jobId: String,
    @SerialName("client_id") val clientId: String,
    val title: String,
    val category: String,
    val description: String,
    @SerialName("required_skills") val requiredSkills: List<String>,
    @SerialName("pay_min") val payMin: Double,
    @SerialName("pay_max") val payMax: Double,
    val duration: String,
    @SerialName("location_type") val locationType: String,
    val location: String? = null,
    val status: String
)

@Serializable
data class ProposalInsert(
    @SerialName("job_id") val jobId: String,
    @SerialName("freelancer_id") val freelancerId: String,
    @SerialName("cover_letter") val coverLetter: String,
    @SerialName("proposed_rate") val proposedRate: Double,
    @SerialName("estimated_timeline") val estimatedTimeline: String
)