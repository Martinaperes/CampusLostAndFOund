package com.example.campuslostandfound.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LostFoundItemDao {

    @Insert
    suspend fun insertItem(item: LostFoundItemEntity): Long

    @Query("SELECT * FROM lost_found_items")
    suspend fun getAllItems(): List<LostFoundItemEntity>

    @Query(
        "SELECT * FROM lost_found_items WHERE itemId = :itemId"
    )
    suspend fun getItemById(itemId: Int): LostFoundItemEntity?

    @Query(
        "SELECT * FROM lost_found_items WHERE userId = :userId"
    )
    suspend fun getItemsByUser(userId: Int): List<LostFoundItemEntity>

    @Update
    suspend fun updateItem(item: LostFoundItemEntity)

    @Delete
    suspend fun deleteItem(item: LostFoundItemEntity)
}