package com.example.campuslostandfound.screens.founditems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.screens.founditems.components.FoundItemCard
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoundItemsScreen(){
    var searchQuery by remember{
        mutableStateOf("")
    }

    val foundItems=listOf(
        FoundItem(
            "iPhone 17",
            "Engineering block",
            "Today"
        ),
        FoundItem(
            "Black Backpack",
            "Main Library",
            "Yesterday"
        ),
        FoundItem(
            "Macbook M5",
            "D-block",
            "Today"
        ),
        FoundItem(
            "Student ID",
            "Cafeteria",
            "2 days ago"
        )

    )
    val filteredItems=foundItems.filter{item->
        item.itemName.contains(searchQuery,ignoreCase=true)

    }
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title={
                    Text("Found Items")
                }
            )
        }
    ){ paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement= Arrangement.spacedBy(8.dp)
        ) {
            item{
                OutlinedTextField(
                    value=searchQuery,
                    onValueChange = {
                        searchQuery=it
                    },
                    label={
                        Text("Search found items")
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            items(filteredItems){item->
                FoundItemCard(
                    itemName=item.itemName,
                    location = item.location,
                    date=item.date,
                    onClick = {
                        //add navigation later
                    }
                )
            }
        }
    }
}