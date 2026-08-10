package com.example.campuslostandfound.screens.reportlost

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.campuslostandfound.data.local.LostFoundItemEntity
import com.example.campuslostandfound.data.repository.LostFoundRepository
import kotlinx.coroutines.launch

class ReportLostViewModel(
    private val repository: LostFoundRepository
) : ViewModel() {

    fun submitReport(
        userId: Int,
        itemName: String,
        category: String,
        description: String,
        location: String,
        date: String,
        serialNumber: String?,
        imageUri: String?,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

        if (itemName.isBlank()) {
            onError("Please enter the item name")
            return
        }

        if (category.isBlank()) {
            onError("Please select a category")
            return
        }

        if (location.isBlank()) {
            onError("Please enter where the item was lost")
            return
        }

        if (description.isBlank()) {
            onError("Please provide a description")
            return
        }

        val item = LostFoundItemEntity(
            userId = userId,
            itemName = itemName,
            category = category,
            type = "LOST",
            description = description,
            location = location,
            date = date,
            serialNumber = serialNumber,
            imageUri = imageUri,
            status = "PENDING"
        )

        viewModelScope.launch {

            try {

                repository.createItem(item)

                onSuccess()

            } catch (e: Exception) {

                onError(
                    e.message ?: "Failed to save report"
                )
            }
        }
    }
}