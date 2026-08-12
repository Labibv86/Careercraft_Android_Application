package com.example.careercraft.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JobTitleOnly(val title: String)

@Serializable
data class ProposalWithJob(
    @SerialName("proposal_id") val proposalId: String,
    @SerialName("job_id") val jobId: String,
    @SerialName("proposed_rate") val proposedRate: Double,
    @SerialName("estimated_timeline") val estimatedTimeline: String,
    val status: String,
    val jobs: JobTitleOnly,
    val contracts: List<ContractRef> = emptyList()
)