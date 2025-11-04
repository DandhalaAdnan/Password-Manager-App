package com.adnan.passwordmanager.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adnan.passwordmanager.domain.model.PasswordItem
import com.adnan.passwordmanager.domain.usecase.PasswordUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

/**
 * Created by Adnan.
 */
@HiltViewModel
class PasswordDetailsViewModel @Inject constructor(
    private val useCases: PasswordUseCases
) : ViewModel() {

    fun delete(item: PasswordItem, onComplete: () -> Unit) {
        viewModelScope.launch {
            useCases.deletePassword(item)
            onComplete()
        }
    }
}
