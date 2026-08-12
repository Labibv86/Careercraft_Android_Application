package com.example.careercraft.data.supabase

import com.example.careercraft.data.models.ProposalWithJob
import io.github.jan.supabase.postgrest.query.Columns
import com.example.careercraft.data.models.Job
import com.example.careercraft.data.models.ProposalInsert
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Order

class JobRepository {
    private val postgrest = SupabaseClient.client.postgrest

    suspend fun getOpenJobs(preferredCategory: String?): List<Job> {
        val jobs = postgrest.from("jobs")
            .select {
                filter { eq("status", "open") }
                order("created_at", Order.DESCENDING)
            }
            .decodeList<Job>()
        return if (preferredCategory != null) {
            jobs.sortedByDescending { it.category.equals(preferredCategory, ignoreCase = true) }
        } else jobs
    }

    suspend fun getJob(jobId: String): Job {
        return postgrest.from("jobs")
            .select {
                filter { eq("job_id", jobId) }
            }
            .decodeSingle()
    }

    suspend fun submitProposal(jobId: String, freelancerId: String, coverLetter: String, proposedRate: Double, estimatedTimeline: String) {
        postgrest.from("proposals").insert(
            ProposalInsert(jobId, freelancerId, coverLetter, proposedRate, estimatedTimeline)
        )
    }

    suspend fun getMyProposals(freelancerId: String): List<ProposalWithJob> {
        return postgrest.from("proposals")
            .select(Columns.raw("proposal_id, job_id, proposed_rate, estimated_timeline, status, jobs(title), contracts(contract_id)")) {
                filter { eq("freelancer_id", freelancerId) }
                order("created_at", Order.DESCENDING)
            }
            .decodeList()
    }

    suspend fun withdrawProposal(proposalId: String) {
        postgrest.from("proposals").update(
            mapOf("status" to "withdrawn")
        ) {
            filter { eq("proposal_id", proposalId) }
        }
    }


}