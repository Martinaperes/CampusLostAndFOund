package com.example.campuslostandfound.data.repository

import com.example.campuslostandfound.data.local.UserDao
import com.example.campuslostandfound.data.local.UserEntity

class UserRepository(
    private val userDao: UserDao
) {

    // CREATE
    suspend fun createUser(
        user: UserEntity
    ): Long {
        return userDao.insertUser(user)
    }

    // READ
    suspend fun getUserById(
        userId: Int
    ): UserEntity? {
        return userDao.getUserById(userId)
    }

    // READ using Firebase UID
    suspend fun getUserByFirebaseUid(
        firebaseUid: String
    ): UserEntity? {
        return userDao.getUserByFirebaseUid(firebaseUid)
    }

    suspend fun getAllUsers(): List<UserEntity> {
        return userDao.getAllUsers()
    }

    // UPDATE
    suspend fun updateUser(
        user: UserEntity
    ) {
        userDao.updateUser(user)
    }

    // DELETE
    suspend fun deleteUser(
        user: UserEntity
    ) {
        userDao.deleteUser(user)
    }
}