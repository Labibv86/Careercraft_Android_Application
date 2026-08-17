package com.example.careercraft.data.supabase

import com.example.careercraft.data.models.ReviewInsert
import com.example.careercraft.data.models.ChatMessage
import com.example.careercraft.data.models.Contract
import com.example.careercraft.data.models.MessageInsert
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Order
import com.example.careercraft.data.models.ContractSummary
import com.example.careercraft.data.models.ProposalDetails
import com.example.careercraft.data.models.ReviewRecord

class ContractRepository {
    private val postgrest = SupabaseClient.client.postgrest

    suspend fun getContract(contractId: String): Contract {
        return postgrest.from("contracts")
            .select { filter { eq("contract_id", contractId) } }
            .decodeSingle()
    }

    suspend fun getMessages(contractId: String): List<ChatMessage> {
        return postgrest.from("messages")
            .select {
                filter { eq("contract_id", contractId) }
                order("created_at", Order.ASCENDING)
            }
            .decodeList()
    }

    suspend fun sendMessage(contractId: String, senderId: String, receiverId: String, content: String) {
        postgrest.from("messages").insert(MessageInsert(contractId, senderId, receiverId, content))
    }

    suspend fun submitReview(contractId: String, reviewerId: String, revieweeId: String, rating: Int, feedback: String?) {
        postgrest.from("reviews").insert(
            ReviewInsert(contractId, reviewerId, revieweeId, rating, feedback?.ifBlank { null })
        )
    }

    suspend fun getMyContracts(userId: String): List<ContractSummary> {
        val asFreelancer = postgrest.from("active_contracts")
            .select { filter { eq("freelancer_id", userId) } }
            .decodeList<ContractSummary>()
        val asClient = postgrest.from("active_contracts")
            .select { filter { eq("client_id", userId) } }
            .decodeList<ContractSummary>()
        return asFreelancer + asClient
    }

    suspend fun getLastMessage(contractId: String): ChatMessage? {
        return postgrest.from("messages")
            .select {
                filter { eq("contract_id", contractId) }
                order("created_at", Order.DESCENDING)
                limit(1)
            }
            .decodeList<ChatMessage>()
            .firstOrNull()
    }

    suspend fun getContractIdForJob(jobId: String): String? {
        return postgrest.from("contracts")
            .select { filter { eq("job_id", jobId) } }
            .decodeList<Contract>()
            .firstOrNull()?.contractId
    }

    suspend fun markComplete(contractId: String, isFreelancer: Boolean) {
        val field = if (isFreelancer) "freelancer_completed" else "client_completed"
        postgrest.from("contracts").update(mapOf(field to true)) {
            filter { eq("contract_id", contractId) }
        }
        postgrest.rpc("complete_contract", buildJsonObject {
            put("contract_id_param", contractId)
        })
    }

    suspend fun getContractsForFreelancer(freelancerId: String): List<Contract> {
        return postgrest.from("contracts")
            .select { filter { eq("freelancer_id", freelancerId) } }
            .decodeList()
    }


    suspend fun getProposal(proposalId: String): ProposalDetails {
        return postgrest.from("proposals")
            .select { filter { eq("proposal_id", proposalId) } }
            .decodeSingle()
    }

    suspend fun getReviews(contractId: String): List<ReviewRecord> {
        return postgrest.from("reviews")
            .select { filter { eq("contract_id", contractId) } }
            .decodeList()
    }

    suspend fun hasReviewed(contractId: String, reviewerId: String): Boolean {
        val existing = postgrest.from("reviews")
            .select {
                filter {
                    eq("contract_id", contractId)
                    eq("reviewer_id", reviewerId)
                }
            }
            .decodeList<ReviewRecord>()
        return existing.isNotEmpty()
    }
}