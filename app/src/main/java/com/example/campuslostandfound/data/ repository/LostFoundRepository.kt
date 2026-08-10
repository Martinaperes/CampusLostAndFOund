package com.example.campuslostandfound.data.repository

import com.example.campuslostandfound.data.local.LostFoundItemDao
import com.example.campuslostandfound.data.local.LostFoundItemEntity
import com.example.campuslostandfound.data.local.UserDao
import com.example.campuslostandfound.data.local.UserEntity

class LostFoundRepository(
    private val userDao: UserDao,
    private val itemDao: LostFoundItemDao
) {

    // -------------------------
    // USER OPERATIONS
    // -------------------------

    suspend fun createUser(user: UserEntity): Long {
        return userDao.insertUser(user)
    }

    suspend fun getUser(userId: Int): UserEntity? {
        return userDao.getUserById(userId)
    }

    suspend fun getUsers(): List<UserEntity> {
        return userDao.getAllUsers()
    }

    suspend fun updateUser(user: UserEntity) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: UserEntity) {
        userDao.deleteUser(user)
    }


    // -------------------------
    // ITEM OPERATIONS
    // -------------------------

    suspend fun createItem(item: LostFoundItemEntity): Long {
        return itemDao.insertItem(item)
    }

    suspend fun getItems(): List<LostFoundItemEntity> {
        return itemDao.getAllItems()
    }

    suspend fun getItem(itemId: Int): LostFoundItemEntity? {
        return itemDao.getItemById(itemId)
    }

    suspend fun getUserItems(userId: Int): List<LostFoundItemEntity> {
        return itemDao.getItemsByUser(userId)
    }

    suspend fun updateItem(item: LostFoundItemEntity) {
        itemDao.updateItem(item)
    }

    suspend fun deleteItem(item: LostFoundItemEntity) {
        itemDao.deleteItem(item)
    }
}