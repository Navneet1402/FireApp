package com.example.fireapp.ui.screens.Login.register

import androidx.lifecycle.ViewModel
import com.example.fireapp.service.AuthService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegisterViewModel() : ViewModel(){
    private val _state = MutableStateFlow(RegisterState())
    val state = _state.asStateFlow()
    private val authService = AuthService()

    fun onEvent(event: RegisterEvent){
        when(event){
            RegisterEvent.OnNavigateToLogin -> TODO()
            RegisterEvent.OnSaveUser ->{
                authService.register(state.value)

            }
            is RegisterEvent

        }
    }
}