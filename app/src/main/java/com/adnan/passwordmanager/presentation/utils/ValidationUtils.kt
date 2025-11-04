package com.adnan.passwordmanager.presentation.utils

/**
 * Created by Adnan.
 */
object ValidationUtils {

    fun validateNotEmpty(value: String, fieldName: String): String? {
        return if (value.isBlank()) "$fieldName is required" else null
    }

    fun validateEmailFormat(value: String): String? {
        // Basic email check (clean + interview-friendly)
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()

        return if (!emailRegex.matches(value)) {
            "Please enter a valid email"
        } else null
    }
}
