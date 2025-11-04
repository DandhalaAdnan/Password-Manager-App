package com.adnan.passwordmanager.di

import com.adnan.passwordmanager.data.encryption.CryptoManager
import com.adnan.passwordmanager.data.local.PasswordDao
import com.adnan.passwordmanager.data.repository.PasswordRepositoryImpl
import com.adnan.passwordmanager.domain.repository.PasswordRepository
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
object RepositoryModule {

    @Provides
    @Singleton
    fun providePasswordRepository(
        dao: PasswordDao,
        crypto: CryptoManager
    ): PasswordRepository {
        return PasswordRepositoryImpl(dao, crypto)
    }
}
