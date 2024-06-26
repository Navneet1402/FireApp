package com.example.fireapp.service

import com.example.fireapp.ui.screens.Login.LoginUiState
import com.example.fireapp.ui.screens.Register.RegisterEvent
import com.example.fireapp.ui.screens.Register.RegisterState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.userProfileChangeRequest
import com.google.firebase.ktx.Firebase

class AuthService(
    private val auth: FirebaseAuth = Firebase.auth,
) {
    fun login(state: LoginUiState) {
        auth.signInWithEmailAndPassword(state.email, state.password).addOnFailureListener {
           state.error = it.message ?: "An error occurred"
            state.isLoading = false
        }.addOnSuccessListener {
            state.isLoading = false
            state.error = ""
            state.isLoginSuccess = true

        }
    }

    fun register(state: RegisterState) {
        auth.createUserWithEmailAndPassword(state.email, state.password)
            .addOnFailureListener {
            state.error = it.message ?: "An error occurred"
            state.isLoading = false
        }.addOnSuccessListener {
            state.isLoading = false
            state.error = ""
            state.isRegisterSuccess = true
            val profileUpdates = userProfileChangeRequest { displayName = state.username }
            it.user?.updateProfile(profileUpdates)

        }
    }
    fun isUserLoggedIn(): Boolean {
        return auth.currentUser != null
    }
}