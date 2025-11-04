package com.adnan.passwordmanager.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Adnan.
 */
@Entity(tableName = "passwords")
data class PasswordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val accountName: String,
    val username: String,
    val encryptedPassword: String
)

