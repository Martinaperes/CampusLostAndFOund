package com.example.campuslostandfound.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.campuslostandfound.data.repository.UserRepository
import com.example.campuslostandfound.firebase.AuthRepository
import kotlinx.coroutines.launch
import com.example.campuslostandfound.data.session.SessionManager

class LoginViewModel(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository,
    private val sessionManager: SessionManager
) : ViewModel() {

    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {

        authRepository.loginUser(
            email = email,
            password = password,

            onSuccess = {

                val firebaseUid =
                    authRepository.getCurrentUserUid()

                if (firebaseUid == null) {
                    onFailure("Could not identify logged-in user")
                    return@loginUser
                }

                viewModelScope.launch {

                    try {

                        val user =
                            userRepository.getUserByFirebaseUid(
                                firebaseUid
                            )

                        if (user == null) {

                            onFailure(
                                "User profile not found in local database"
                            )

                        } else {

                            sessionManager.saveUserId(user.userId)

                            onSuccess()
                        }

                    } catch (e: Exception) {

                        onFailure(
                            e.message
                                ?: "Failed to retrieve user"
                        )
                    }
                }
            },

            onFailure = { error ->
                onFailure(error)
            }
        )
    }
    fun logout() {
        authRepository.logout()
        sessionManager.clearSession()
    }
}