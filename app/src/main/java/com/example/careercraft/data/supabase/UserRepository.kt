package com.example.careercraft.data.supabase
import com.example.careercraft.data.models.CategorySelectionUpdate
import com.example.careercraft.data.models.UserProfileInsert
import io.github.jan.supabase.postgrest.postgrest

class UserRepository {
    private val postgrest = SupabaseClient.client.postgrest

    suspend fun createProfile(userId: String, email: String, displayName: String, role: String, userType: String) {
        postgrest.from("users").insert(
            UserProfileInsert(userId, email, displayName, role, userType)
        )
    }
    suspend fun updateCategories(userId: String, categories: List<String>) {
        postgrest.from("users").update(
            CategorySelectionUpdate(selectedCategories = categories)
        ) {
            filter { eq("user_id", userId) }
        }
    }
}