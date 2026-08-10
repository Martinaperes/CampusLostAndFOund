package com.example.campuslostandfound.screens.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.campuslostandfound.data.local.UserEntity
import com.example.campuslostandfound.data.repository.UserRepository
import com.example.campuslostandfound.firebase.AuthRepository
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    fun register(
        email: String,
        password: String,
        registrationNumber: String,
        name: String,
        department: String,
        phoneNumber: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {

        authRepository.registerUser(
            email = email,
            password = password,
            onSuccess = {

                val firebaseUid =
                    authRepository.getCurrentUserUid()

                if (firebaseUid == null) {
                    onFailure("Could not get Firebase user ID")
                    return@registerUser
                }

                viewModelScope.launch {

                    try {

                        val user = UserEntity(
                            firebaseUid = firebaseUid,
                            registrationNumber = registrationNumber,
                            name = name,
                            department = department,
                            phoneNumber = phoneNumber,
                            email = email
                        )

                        userRepository.createUser(user)

                        onSuccess()

                    } catch (exception: Exception) {

                        onFailure(
                            exception.message
                                ?: "Failed to save user"
                        )
                    }
                }
            },
            onFailure = { error ->
                onFailure(error)
            }
        )
    }
}