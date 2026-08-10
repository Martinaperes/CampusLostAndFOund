package com.example.campuslostandfound.data.repository

import com.example.campuslostandfound.data.local.LostFoundItemDao
import com.example.campuslostandfound.data.local.LostFoundItemEntity

class LostFoundRepository(
    private val itemDao: LostFoundItemDao
) {

    // CREATE
    suspend fun createItem(
        item: LostFoundItemEntity
    ): Long {
        return itemDao.insertItem(item)
    }

    // READ - all items
    suspend fun getAllItems(): List<LostFoundItemEntity> {
        return itemDao.getAllItems()
    }

    // READ - one item
    suspend fun getItemById(
        itemId: Int
    ): LostFoundItemEntity? {
        return itemDao.getItemById(itemId)
    }

    // READ - user's items
    suspend fun getItemsByUser(
        userId: Int
    ): List<LostFoundItemEntity> {
        return itemDao.getItemsByUser(userId)
    }

    // UPDATE
    suspend fun updateItem(
        item: LostFoundItemEntity
    ) {
        itemDao.updateItem(item)
    }

    // DELETE
    suspend fun deleteItem(
        item: LostFoundItemEntity
    ) {
        itemDao.deleteItem(item)
    }
}