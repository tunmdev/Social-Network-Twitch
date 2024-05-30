package com.tunm17.socialnetworktwitch.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RegisterViewModel: ViewModel() {

    private val _usernameText = mutableStateOf("")
    val usernameText: State<String> = _usernameText

    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText

    private val _emailText = mutableStateOf("")
    val emailText: State<String> = _emailText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _usernameError = mutableStateOf("")
    val usernameError: State<String> = _usernameError

    private val _emailError = mutableStateOf("")
    val emailError: State<String> = _emailError

    private val _passwordError = mutableStateOf("")
    val passwordError: State<String> = _passwordError

    fun setUsernameText(username: String) {
        _usernameText.value = username
    }

    fun setPasswordText(password: String) {
        _passwordText.value = password
    }

    fun setUsernameError(error: String) {
        _usernameError.value = error
    }

    fun setEmailError(error: String) {
        _emailError.value = error
    }

    fun setEmailText(email: String) {
        _emailText.value = email
    }

    fun setPasswordError(error: String) {
        _passwordError.value = error
    }

    fun setShowPassword(showPassword: Boolean) {
        _showPassword.value = showPassword
    }
}