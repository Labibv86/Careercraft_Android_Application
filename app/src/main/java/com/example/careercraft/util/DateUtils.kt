package com.example.careercraft.util

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

fun isPastDeadline(deadline: String?): Boolean {
    if (deadline.isNullOrBlank()) return false
    return try {
        Instant.parse(deadline).isBefore(Instant.now())
    } catch (e: Exception) {
        try {
            LocalDateTime.parse(deadline).atOffset(ZoneOffset.UTC).toInstant().isBefore(Instant.now())
        } catch (e2: Exception) {
            false // unparseable date -> don't incorrectly flag as overdue
        }
    }
}