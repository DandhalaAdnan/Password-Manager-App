package com.adnan.passwordmanager.domain.model

/**
 * Created by Adnan.
 */
data class PasswordItem(
    val id: Int? = 0,
    val accountName: String,
    val username: String,
    val password: String
)