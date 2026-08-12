package com.example.careercraft.data.supabase

import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import com.example.careercraft.data.models.JobInsert
import com.example.careercraft.data.models.JobWithApplicantCounts
import com.example.careercraft.data.models.ProposalWithFreelancer
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.query.Order

class ClientRepository {
    private val postgrest = SupabaseClient.client.postgrest

    suspend fun getMyJobs(clientId: String): List<JobWithApplicantCounts> {
        return postgrest.from("job_details_with_applicants")
            .select {
                filter { eq("client_id", clientId) }
            }
            .decodeList()
    }

    suspend fun postJob(job: JobInsert) {
        postgrest.from("jobs").insert(job)
    }

    suspend fun getApplicants(jobId: String): List<ProposalWithFreelancer> {
        return postgrest.from("proposals")
            .select(Columns.raw("proposal_id, freelancer_id, cover_letter, proposed_rate, estimated_timeline, status, users(display_name, rating_score)")) {
                filter { eq("job_id", jobId) }
                order("created_at", Order.DESCENDING)
            }
            .decodeList()
    }

    suspend fun hireFreelancer(proposalId: String) {
        postgrest.rpc("hire_freelancer", buildJsonObject {
            put("proposal_id_param", proposalId)
        })
    }
}