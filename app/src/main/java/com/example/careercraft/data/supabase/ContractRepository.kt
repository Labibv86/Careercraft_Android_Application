package com.example.careercraft.data.supabase

import com.example.careercraft.data.models.ChatMessage
import com.example.careercraft.data.models.CompleteContractParams
import com.example.careercraft.data.models.Contract
import com.example.careercraft.data.models.MessageInsert
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Order

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

    suspend fun markComplete(contractId: String, isFreelancer: Boolean) {
        val field = if (isFreelancer) "freelancer_completed" else "client_completed"
        postgrest.from("contracts").update(mapOf(field to true)) {
            filter { eq("contract_id", contractId) }
        }
        postgrest.rpc("complete_contract", CompleteContractParams(contractId))
    }
}