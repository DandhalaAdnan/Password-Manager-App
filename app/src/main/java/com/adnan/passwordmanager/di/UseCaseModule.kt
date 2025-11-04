package com.adnan.passwordmanager.di

import com.adnan.passwordmanager.domain.repository.PasswordRepository
import com.adnan.passwordmanager.domain.usecase.AddPassword
import com.adnan.passwordmanager.domain.usecase.DeletePassword
import com.adnan.passwordmanager.domain.usecase.GetPasswords
import com.adnan.passwordmanager.domain.usecase.PasswordUseCases
import com.adnan.passwordmanager.domain.usecase.UpdatePassword
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
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCases(passwordRepository: PasswordRepository): PasswordUseCases {
        return PasswordUseCases(
            getPasswords = GetPasswords(passwordRepository),
            addPassword = AddPassword(passwordRepository),
            updatePassword = UpdatePassword(passwordRepository),
            deletePassword = DeletePassword(passwordRepository)
        )
    }
}
