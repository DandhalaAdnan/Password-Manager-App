package com.adnan.passwordmanager.di

import android.app.Application
import androidx.room.Room
import com.adnan.passwordmanager.data.encryption.CryptoManager
import com.adnan.passwordmanager.data.local.PasswordDao
import com.adnan.passwordmanager.data.local.PasswordDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

/**
 * Created by Adnan.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): PasswordDatabase {
        return Room.databaseBuilder(
            app,
            PasswordDatabase::class.java,
            "passwords.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(db: PasswordDatabase): PasswordDao = db.passwordDao()

    @Provides
    @Singleton
    fun provideCryptoManager(): CryptoManager = CryptoManager()
}