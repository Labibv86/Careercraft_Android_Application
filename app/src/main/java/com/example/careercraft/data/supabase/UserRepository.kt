package com.example.careercraft.data.supabase
import com.example.careercraft.data.models.CategorySelectionUpdate
import com.example.careercraft.data.models.UserProfileInsert
import io.github.jan.supabase.postgrest.postgrest
import com.example.careercraft.data.models.CareerMatchUpdate
import com.example.careercraft.data.models.UserProfileData

class UserRepository {
    private val postgrest = SupabaseClient.client.postgrest

    suspend fun createProfile(userId: String, email: String, displayName: String, role: String, userType: String) {
        postgrest.from("users").insert(
            UserProfileInsert(userId, email, displayName, role, userType)
        )
    }
    suspend fun updateCategories(userId: String, categories: List<String>, careerPath: String) {
        postgrest.from("users").update(
            CategorySelectionUpdate(selectedCategories = categories, careerPath = careerPath)
        ) {
            filter { eq("user_id", userId) }
        }
    }

    suspend fun saveCareerMatch(userId: String, predictedClass: Int, careerPath: String) {
        postgrest.from("users").update(
            CareerMatchUpdate(predictedClass = predictedClass, careerPath = careerPath)
        ) {
            filter { eq("user_id", userId) }
        }
    }
    suspend fun getProfile(userId: String): UserProfileData {
        return postgrest.from("users")
            .select {
                filter { eq("user_id", userId) }
            }
            .decodeSingle()
    }
}