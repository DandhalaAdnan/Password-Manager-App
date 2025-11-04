package com.adnan.passwordmanager.domain.usecase

import com.adnan.passwordmanager.domain.model.PasswordItem
import com.adnan.passwordmanager.domain.repository.PasswordRepository

/**
 * Created by Adnan.
 */
class DeletePassword(private val repo: PasswordRepository) {
 suspend operator fun invoke(item: PasswordItem) = repo.delete(item)
}
