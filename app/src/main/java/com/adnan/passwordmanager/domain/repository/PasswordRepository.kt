package com.adnan.passwordmanager.domain.repository

import com.adnan.passwordmanager.domain.model.PasswordItem
import kotlinx.coroutines.flow.Flow

/**
 * Created by Adnan.
 */
interface PasswordRepository {
    fun getAll(): Flow<List<PasswordItem>>
    suspend fun add(item: PasswordItem)
    suspend fun update(item: PasswordItem)
    suspend fun delete(item: PasswordItem)
}
