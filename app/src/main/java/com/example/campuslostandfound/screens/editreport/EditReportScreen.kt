package com.example.campuslostandfound.screens.editreport

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.campuslostandfound.data.local.DatabaseProvider
import com.example.campuslostandfound.data.local.LostFoundItemEntity
import com.example.campuslostandfound.data.repository.LostFoundRepository
import kotlinx.coroutines.launch

@Composable
fun EditReportScreen(
    itemId: Int,
    navController: NavController
) {

    val context = LocalContext.current

    val database = remember {
        DatabaseProvider.getDatabase(context)
    }

    val repository = remember {
        LostFoundRepository(
            database.lostFoundItemDao()
        )
    }

    val scope = rememberCoroutineScope()

    var item by remember {
        mutableStateOf<LostFoundItemEntity?>(null)
    }

    var itemName by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var itemType by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var serialNumber by remember { mutableStateOf("") }

    var isLoading by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(itemId) {

        try {

            val loadedItem = repository.getItemById(itemId)

            item = loadedItem

            if (loadedItem != null) {

                itemName = loadedItem.itemName
                category = loadedItem.category
                itemType = loadedItem.type
                location = loadedItem.location
                description = loadedItem.description
                serialNumber = loadedItem.serialNumber ?: ""
            }

        } catch (e: Exception) {

            Toast.makeText(
                context,
                "Failed to load report",
                Toast.LENGTH_LONG
            ).show()

        } finally {

            isLoading = false
        }
    }

    if (isLoading) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            CircularProgressIndicator()
        }

        return
    }

    if (item == null) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Text("Report not found")
        }

        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Edit Report",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        OutlinedTextField(
            value = itemName,
            onValueChange = {
                itemName = it
            },
            label = {
                Text("Item Name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = category,
            onValueChange = {
                category = it
            },
            label = {
                Text("Category")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = itemType,
            onValueChange = {
                itemType = it
            },
            label = {
                Text("Item Type")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = location,
            onValueChange = {
                location = it
            },
            label = {
                Text("Last Seen Location")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = description,
            onValueChange = {
                description = it
            },
            label = {
                Text("Description")
            },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = serialNumber,
            onValueChange = {
                serialNumber = it
            },
            label = {
                Text("Serial Number")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Button(
            onClick = {

                val updatedItem = item!!.copy(
                    itemName = itemName,
                    category = category,
                    type = itemType,
                    location = location,
                    description = description,
                    serialNumber =
                        serialNumber.ifBlank {
                            null
                        }
                )

                scope.launch {

                    try {

                        repository.updateItem(
                            updatedItem
                        )

                        Toast.makeText(
                            context,
                            "Report updated successfully!",
                            Toast.LENGTH_SHORT
                        ).show()

                        navController.popBackStack()

                    } catch (e: Exception) {

                        Toast.makeText(
                            context,
                            "Update failed: ${e.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {

            Text("SAVE CHANGES")
        }
    }
}