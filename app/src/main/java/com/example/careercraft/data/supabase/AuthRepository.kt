package com.example.careercraft.data.supabase

import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

class AuthRepository {
    private val auth = SupabaseClient.client.auth

    suspend fun signUp(email: String, password: String, fullName: String) {
        auth.signUpWith(Email) {
            this.email = email
            this.password = password
            data = buildJsonObject {
                put("full_name", fullName)
            }
        }
    }

    suspend fun signIn(email: String, password: String) {
        auth.signInWith(Email) {
            this.email = email
            this.password = password
        }
    }

    suspend fun signOut() {
        auth.signOut()
    }

    fun currentUserId(): String? = auth.currentUserOrNull()?.id

    fun currentUserEmail(): String? = auth.currentUserOrNull()?.email

    fun currentUserFullName(): String? {
        val metadata = auth.currentUserOrNull()?.userMetadata
        val value = metadata?.get("full_name") ?: return null
        return if (value is kotlinx.serialization.json.JsonPrimitive) value.content else null
    }
}