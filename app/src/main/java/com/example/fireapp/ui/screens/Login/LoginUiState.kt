package com.example.fireapp.ui.screens.Login

class LoginUiState(
    val email: String = "",
    val password: String = "",
    var isLoading: Boolean = false,
    var error: String = "",
    var isLoginSuccess: Boolean = false
)