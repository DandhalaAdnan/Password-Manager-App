package com.adnan.passwordmanager.presentation.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adnan.passwordmanager.domain.model.PasswordItem
import com.adnan.passwordmanager.domain.usecase.PasswordUseCases
import com.adnan.passwordmanager.presentation.utils.ValidationUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

/**
 * Created by Adnan.
 */
@HiltViewModel
class AddPasswordViewModel @Inject constructor(
    private val useCases: PasswordUseCases
) : ViewModel() {

    var account by mutableStateOf("")
    var username by mutableStateOf("")
    var password by mutableStateOf("")
    var accountError by mutableStateOf<String?>(null)
    var usernameError by mutableStateOf<String?>(null)
    var passwordError by mutableStateOf<String?>(null)
    var editingId: Int? = null

    fun loadForEdit(item: PasswordItem) {
        editingId = item.id
        account = item.accountName
        username = item.username
        password = item.password
    }

    fun clear() {
        editingId = null
        account = ""
        username = ""
        password = ""
        accountError = null
        usernameError = null
        passwordError = null
    }

    fun validate(): Boolean {
        accountError = ValidationUtils.validateNotEmpty(account, "Account name")

        usernameError = when {
            username.isBlank() -> "Username or email is required"
            !ValidationUtils.validateEmailFormat(username).isNullOrEmpty() ->
                ValidationUtils.validateEmailFormat(username)

            else -> null
        }

        passwordError = ValidationUtils.validateNotEmpty(password, "Password")

        return accountError == null && usernameError == null && passwordError == null
    }


    fun save(onDone: () -> Unit) {
        if (!validate()) return
        viewModelScope.launch {
            if (editingId == null) {
                useCases.addPassword(
                    PasswordItem(
                        id = null,
                        accountName = account,
                        username = username,
                        password = password
                    )
                )
            } else {
                useCases.updatePassword(
                    PasswordItem(
                        id = editingId,
                        accountName = account,
                        username = username,
                        password = password
                    )
                )
            }
            clear()
            onDone()
        }
    }
}
