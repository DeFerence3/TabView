package com.udyata.amrita.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    val loginCredentials by lazy {
        MutableStateFlow(
            LoginCredentials("", "")
        )
    }

    val loginResultFlow: MutableSharedFlow<Boolean> = MutableSharedFlow()

    fun login() {
        viewModelScope.launch {
            delay(1000L)
                loginResultFlow.emit(true)
        }
    }

    fun onUsernameChange(username: String) {
        loginCredentials.update {
            it.copy(username = username)
        }
    }
    fun onPasswordChange(password: String) {
        loginCredentials.update {
            it.copy(password = password)
        }
    }
}

data class LoginCredentials (
    var username: String,
    var password: String
)