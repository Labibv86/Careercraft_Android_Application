package com.example.careercraft.data.supabase

import com.example.careercraft.data.models.PortfolioInsert
import com.example.careercraft.data.models.PortfolioItem
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Order
import io.github.jan.supabase.storage.storage
import java.util.UUID

class PortfolioRepository {
    private val postgrest = SupabaseClient.client.postgrest
    private val storage = SupabaseClient.client.storage

    suspend fun getMyPortfolio(freelancerId: String): List<PortfolioItem> {
        return postgrest.from("portfolio")
            .select {
                filter { eq("freelancer_id", freelancerId) }
                order("created_at", Order.DESCENDING)
            }
            .decodeList()
    }

    suspend fun uploadImage(userId: String, bytes: ByteArray, extension: String): String {
        val path = "$userId/${UUID.randomUUID()}.$extension"
        storage.from("portfolio-images").upload(path, bytes)
        return storage.from("portfolio-images").publicUrl(path)
    }

    suspend fun createPortfolioItem(freelancerId: String, title: String, category: String, description: String?, images: List<String>) {
        postgrest.from("portfolio").insert(
            PortfolioInsert(freelancerId, title, category, description, images)
        )
    }

    suspend fun deletePortfolioItem(portfolioId: String) {
        postgrest.from("portfolio").delete {
            filter { eq("portfolio_id", portfolioId) }
        }
    }
}