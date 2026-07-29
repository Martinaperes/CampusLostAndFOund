package com.example.campuslostandfound.screens.founditems

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.screens.founditems.components.FoundItemCard
import com.example.campuslostandfound.ui.theme.PrimaryGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoundItemsScreen() {

    var searchQuery by remember {
        mutableStateOf("")
    }

    val foundItems = listOf(
        FoundItem(
            "iPhone 17",
            "Engineering Block",
            "Today"
        ),
        FoundItem(
            "Black Backpack",
            "Main Library",
            "Yesterday"
        ),
        FoundItem(
            "MacBook M5",
            "D-Block",
            "Today"
        ),
        FoundItem(
            "Student ID",
            "Cafeteria",
            "2 days ago"
        )
    )

    val filteredItems = foundItems.filter { item ->
        item.itemName.contains(searchQuery, ignoreCase = true) ||
                item.location.contains(searchQuery, ignoreCase = true)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Found Items",
                        style = MaterialTheme.typography.titleLarge,
                        color = PrimaryGreen
                    )
                }
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // Header
            item {

                Column {

                    Text(
                        text = "Browse Found Items",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Search for items that have recently been found around campus.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )

                }

            }

            // Search Bar
            item {

                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = {
                        searchQuery = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text("Search by item or location")
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    },
                    singleLine = true
                )

            }

            // Results count
            item {

                Text(
                    text = "${filteredItems.size} item(s) found",
                    style = MaterialTheme.typography.titleMedium,
                    color = PrimaryGreen,
                    fontWeight = FontWeight.SemiBold
                )

            }

            // Empty State
            if (filteredItems.isEmpty()) {

                item {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 60.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "🔍",
                            style = MaterialTheme.typography.displayMedium
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = "No items found",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "Try searching using another keyword.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )

                    }

                }

            } else {

                items(filteredItems) { item ->

                    FoundItemCard(
                        itemName = item.itemName,
                        location = item.location,
                        date = item.date,
                        onClick = {
                            // Navigate to Item Details later
                        }
                    )

                }

            }

        }

    }

}