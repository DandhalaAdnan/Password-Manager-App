package com.adnan.passwordmanager.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.adnan.passwordmanager.presentation.add.AddPasswordViewModel
import com.adnan.passwordmanager.presentation.details.PasswordDetailsViewModel
import com.adnan.passwordmanager.presentation.home.HomeScreen
import com.adnan.passwordmanager.presentation.home.HomeViewModel
import com.adnan.passwordmanager.presentation.theme.PasswordManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val mHomeViewModel: HomeViewModel by viewModels()
    val mAddViewModel: AddPasswordViewModel by viewModels()
    val mPasswordViewModel: PasswordDetailsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PasswordManagerTheme {
                HomeScreen(
                    homeViewModel = mHomeViewModel,
                    addPasswordViewModel = mAddViewModel,
                    passwordViewModel = mPasswordViewModel
                )
            }
        }
    }
}