package com.example.instadev.view.auth.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUIState())
    val uiState : StateFlow<LoginUIState> = _uiState

    fun onEmailChanged(email: String) {
        _uiState.update { state ->
            state.copy(email = email)
        }
        verifyLogin()
    }

    fun onPasswordChanged(password: String) {
        _uiState.update { state ->
            state.copy(password = password)
        }
        verifyLogin()
    }

    private fun verifyLogin() {
        val enabledLogin: Boolean = isEmailValid(_uiState.value.email) && isPasswordValid(_uiState.value.password)
        _uiState.update { it.copy(isLoginEnabled = enabledLogin) }
    }

    fun isEmailValid(email:String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    fun isPasswordValid(password: String): Boolean = password.length >= 6
}

data class LoginUIState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoginEnabled: Boolean = false
)