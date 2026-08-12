package com.example.campuslostandfound.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.campuslostandfound.data.repository.UserRepository
import com.example.campuslostandfound.firebase.AuthRepository
import com.example.campuslostandfound.data.session.SessionManager
class LoginViewModelFactory(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository,
    private val sessionManager: SessionManager
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {

            return LoginViewModel(
                authRepository,
                userRepository,
                sessionManager
            ) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel class"
        )
    }
}