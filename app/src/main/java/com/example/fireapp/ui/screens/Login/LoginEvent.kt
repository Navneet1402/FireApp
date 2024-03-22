package com.example.fireapp.ui.screens.Login

sealed class LoginEvent{
    data class SetEmail(val email: String) : LoginEvent()
    data class SetPassword(val password: String): LoginEvent()
    data object OnLogin : LoginEvent()
    data object  OnNavigateToRegister : LoginEvent()
}