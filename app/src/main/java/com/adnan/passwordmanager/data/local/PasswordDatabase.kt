package com.adnan.passwordmanager.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adnan.passwordmanager.data.local.PasswordDao

/**
 * Created by Adnan.
 */
@Database(entities = [PasswordEntity::class], version = 1)
abstract class PasswordDatabase : RoomDatabase() {
    abstract fun passwordDao(): PasswordDao
}