package com.adnan.passwordmanager.domain.usecase

/**
 * Created by Adnan.
 */
data class PasswordUseCases(
    val getPasswords: GetPasswords,
    val addPassword: AddPassword,
    val updatePassword: UpdatePassword,
    val deletePassword: DeletePassword
)