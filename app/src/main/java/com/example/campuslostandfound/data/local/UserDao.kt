package com.example.campuslostandfound.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: UserEntity): Long

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM users WHERE userId = :userId")
    suspend fun getUserById(userId: Int): UserEntity?

    @Query(
        "SELECT * FROM users WHERE firebaseUid = :firebaseUid LIMIT 1"
    )
    suspend fun getUserByFirebaseUid(
        firebaseUid: String
    ): UserEntity?

    @Update
    suspend fun updateUser(user: UserEntity)

    @Delete
    suspend fun deleteUser(user: UserEntity)
}