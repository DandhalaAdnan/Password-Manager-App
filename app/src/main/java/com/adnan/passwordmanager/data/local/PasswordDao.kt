package com.adnan.passwordmanager.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Created by Adnan.
 */
@Dao
interface PasswordDao {

    @Query("SELECT * FROM passwords")
    fun getAll(): Flow<List<PasswordEntity>>

    @Insert
    suspend fun add(entity: PasswordEntity)

    @Update
    suspend fun update(entity: PasswordEntity)

    @Delete
    suspend fun delete(entity: PasswordEntity)
}