package com.example.careercraft.data.supabase

import com.example.careercraft.data.models.AssessmentQuestion
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Order

class AssessmentRepository {
    private val postgrest = SupabaseClient.client.postgrest

    suspend fun getQuestions(): List<AssessmentQuestion> {
        return postgrest.from("assessment_questions")
            .select {
                order("display_order", Order.ASCENDING)
            }
            .decodeList()
    }
}