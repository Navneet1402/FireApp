package com.example.fireapp.ui.screens.Login.register

import com.example.fireapp.ui.screens.Login.LoginEvent

open class RegisterEvent {
    data class SetUsername(val username: String): RegisterEvent()
    data class SetEmail(val email: String): RegisterEvent()
    data class SetPassword(val password: String): RegisterEvent()
    data class SetConfirmPassword(val confirmPassword: String):RegisterEvent()
    data object OnSaveUser: RegisterEvent()
    data object OnNavigateToLogin : RegisterEvent()
}