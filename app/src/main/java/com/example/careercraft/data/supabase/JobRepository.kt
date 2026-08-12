package com.example.careercraft.data.supabase

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
}