package com.example.careercraft.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JobInsert(
    @SerialName("client_id") val clientId: String,
    val title: String,
    val category: String,
    val description: String,
    @SerialName("required_skills") val requiredSkills: List<String>,
    @SerialName("pay_min") val payMin: Double,
    @SerialName("pay_max") val payMax: Double,
    val duration: String,
    @SerialName("location_type") val locationType: String,
    val location: String? = null
)

@Serializable
data class JobWithApplicantCounts(
    @SerialName("job_id") val jobId: String,
    val title: String,
    val category: String,
    val status: String,
    @SerialName("total_applicants") val totalApplicants: Int,
    @SerialName("pending_applicants") val pendingApplicants: Int,
    @SerialName("accepted_applicants") val acceptedApplicants: Int
)

@Serializable
data class ApplicantUserInfo(
    @SerialName("display_name") val displayName: String,
    @SerialName("rating_score") val ratingScore: Double
)

@Serializable
data class ProposalWithFreelancer(
    @SerialName("proposal_id") val proposalId: String,
    @SerialName("freelancer_id") val freelancerId: String,
    @SerialName("cover_letter") val coverLetter: String,
    @SerialName("proposed_rate") val proposedRate: Double,
    @SerialName("estimated_timeline") val estimatedTimeline: String,
    val status: String,
    val users: ApplicantUserInfo
)

@Serializable
data class HireFreelancerParams(@SerialName("proposal_id_param") val proposalId: String)