package com.example.campuslostandfound.screens.reportlost

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.components.CustomTextField
import com.example.campuslostandfound.screens.reportlost.components.CategoryDropdown
import com.example.campuslostandfound.screens.reportlost.components.DatePickerField
import com.example.campuslostandfound.screens.reportlost.components.DescriptionField
import com.example.campuslostandfound.screens.reportlost.components.ImagePickerCard
import com.example.campuslostandfound.screens.reportlost.components.SubmitButton
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.example.campuslostandfound.data.local.DatabaseProvider
import com.example.campuslostandfound.data.repository.LostFoundRepository
import com.example.campuslostandfound.data.session.SessionManager
import com.example.campuslostandfound.data.local.LostFoundItemEntity
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ReportLostScreen() {
    val context = LocalContext.current

    val database = remember {
        DatabaseProvider.getDatabase(context)
    }

    val repository = remember {
        LostFoundRepository(
            database.lostFoundItemDao()
        )
    }

    val sessionManager = remember {
        SessionManager(context)
    }
    val currentUserId = sessionManager.getUserId()
    var itemName by remember {
        mutableStateOf("")
    }
    val coroutineScope = rememberCoroutineScope()

    var selectedCategory by remember {
        mutableStateOf("")
    }

    var selectedDate by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var location by remember {
        mutableStateOf("")
    }

    var serialNumber by remember {
        mutableStateOf("")
    }
    var itemType by remember {
        mutableStateOf("")
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {

        item {
            Text(
                text = "Report Lost Item",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            CustomTextField(
                value = itemName,
                onValueChange = {
                    itemName = it
                },
                label = "Item Name",
                placeholder = "e.g Laptop"
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            CategoryDropdown(
                selectedCategory = selectedCategory,
                onCategorySelected = {
                    selectedCategory = it
                }
            )
        }
        item {
            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }

        item {
            CustomTextField(
                value = itemType,
                onValueChange = {
                    itemType = it
                },
                label = "Item Type",
                placeholder = "e.g. Electronics"
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            CustomTextField(
                value = location,
                onValueChange = {
                    location = it
                },
                label = "Last Seen Location",
                placeholder = "e.g Library"
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            DatePickerField(
                selectedDate = selectedDate,
                onDateSelected = {
                    selectedDate = it
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            ImagePickerCard()
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            DescriptionField(
                description = description,
                onDescriptionChange = {
                    description = it
                },
                label = "Description",
                placeholder = "Describe the lost item..."
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            CustomTextField(
                value = serialNumber,
                onValueChange = {
                    serialNumber = it
                },
                label = "Serial Number",
                placeholder = "Enter serial number if applicable"
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            SubmitButton(
                text = "Submit Report",
                onClick = {

                    // Basic validation
                    if (itemName.isBlank()) {
                        Toast.makeText(
                            context,
                            "Please enter the item name",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@SubmitButton
                    }

                    if (selectedCategory.isBlank()) {
                        Toast.makeText(
                            context,
                            "Please select a category",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@SubmitButton
                    }

                    if (itemType.isBlank()) {
                        Toast.makeText(
                            context,
                            "Please enter the item type",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@SubmitButton
                    }

                    if (location.isBlank()) {
                        Toast.makeText(
                            context,
                            "Please enter the last seen location",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@SubmitButton
                    }

                    if (selectedDate.isBlank()) {
                        Toast.makeText(
                            context,
                            "Please select the date lost",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@SubmitButton
                    }

                    if (description.isBlank()) {
                        Toast.makeText(
                            context,
                            "Please enter a description",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@SubmitButton
                    }

                    if (currentUserId == -1) {
                        Toast.makeText(
                            context,
                            "User session not found. Please login again.",
                            Toast.LENGTH_LONG
                        ).show()
                        return@SubmitButton
                    }

                    // Create Room entity
                    val item = LostFoundItemEntity(
                        userId = currentUserId,
                        itemName = itemName,
                        category = selectedCategory,
                        type = itemType,
                        description = description,
                        location = location,
                        date = selectedDate,
                        serialNumber = serialNumber.ifBlank { null },
                        imageUri = null,
                        status = "LOST"
                    )

                    coroutineScope.launch {

                        try {

                            val itemId = repository.createItem(item)

                            Toast.makeText(
                                context,
                                "Report submitted successfully! ID: $itemId",
                                Toast.LENGTH_LONG
                            ).show()

                        } catch (exception: Exception) {

                            Toast.makeText(
                                context,
                                "Failed to save report: ${exception.message}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            )
        }
    }
}