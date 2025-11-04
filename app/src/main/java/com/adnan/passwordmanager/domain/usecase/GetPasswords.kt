package com.adnan.passwordmanager.domain.usecase

import com.adnan.passwordmanager.domain.repository.PasswordRepository

/**
 * Created by Adnan.
 */
class GetPasswords(private val repo: PasswordRepository) {
    operator fun invoke() = repo.getAll()
}