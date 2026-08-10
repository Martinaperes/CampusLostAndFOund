package com.example.campuslostandfound.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    val userId: Int = 0,

    val registrationNumber: String,

    val name: String,

    val department: String,

    val phoneNumber: String,

    val email: String
)