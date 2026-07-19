package com.example.campuslostandfound.firebase

import com.google.firebase.auth.FirebaseAuth
class AuthRepository{
    private val auth= FirebaseAuth.getInstance()
    fun registerUser(
        email:String,
        password:String,
        onSuccess:()->Unit,
        onFailure:(String)->Unit
    ){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                onSuccess
            }
            .addOnFailureListener {exception ->
                onFailure(exception.message ?: "Registration failed")
            }
    }
    fun loginUser(
        email: String,
        password: String,
        onSuccess:()->Unit,
        onFailure:(String)->Unit
    )
    {
        auth.signInWithEmailAndPassword(
            email,password)
                .addOnCompleteListener{task->
                    if(task.isSuccessful){
                        onSuccess()
                    }else{
                        onFailure(task.exception?.message?:"Login failed")
                    }
                }

    }
}