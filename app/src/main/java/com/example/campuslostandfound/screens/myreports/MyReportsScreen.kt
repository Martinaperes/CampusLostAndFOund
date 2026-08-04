package com.example.campuslostandfound.screens.myreports

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.screens.myreports.components.ReportCard

@Composable
fun MyReportsScreen() {

    val reports = listOf(
        ReportItem(
            itemName = "HP Laptop",
            type = "Lost",
            location = "Main Library",
            date = "20 July 2026",
            status = "Searching"
        ),
        ReportItem(
            itemName = "Student ID",
            type = "Found",
            location = "Engineering Block",
            date = "22 July 2026",
            status = "Waiting for Owner"
        ),
        ReportItem(
            itemName = "Black Backpack",
            type = "Lost",
            location = "Cafeteria",
            date = "24 July 2026",
            status = "Claimed"
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {

            Text(
                text = "My Reports",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

        }

        items(reports) { report ->

            ReportCard(
                itemName = report.itemName,
                type = report.type,
                location = report.location,
                date = report.date,
                status = report.status,
                onClick = {
                    // Open report details later
                }
            )

        }

    }

}