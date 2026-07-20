package com.example.campuslostandfound.screens.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class RecentItem(
    val itemName:String,
    val location: String,
    val date: String
)
@Composable
fun RecentItemsSection(){
    val recentItems=listOf(
        RecentItem("HP Laptop", "Main Library", "Yesterday"),
        RecentItem("Student ID", "Engineering Block", "Today"),
        RecentItem("Backpack", "Cafeteria", "2 days ago")
    )
    Column(
        modifier = Modifier.padding(top=24.dp)
    ) {
        Text(
            text="Recent Items",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 16.dp )
        ) {
            items(recentItems){
                item->
                RecentItemCard(
                    itemName=item.itemName,
                    location = item.location,
                    date = item.date,
                    onClick={
                        //details screen later
                    }
                )
            }
        }
    }
}