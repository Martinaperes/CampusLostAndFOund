package com.example.campuslostandfound.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "lost_found_items",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class LostFoundItemEntity(

    @PrimaryKey(autoGenerate = true)
    val itemId: Int = 0,

    val userId: Int,

    val itemName: String,

    val category: String,

    val type: String,

    val description: String,

    val location: String,

    val date: String,

    val serialNumber: String?,

    val imageUri: String?,

    val status: String
)