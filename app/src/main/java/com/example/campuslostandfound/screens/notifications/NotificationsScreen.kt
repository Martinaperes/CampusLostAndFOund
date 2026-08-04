package com.example.campuslostandfound.screens.notifications

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.screens.notifications.components.NotificationCard

@Composable
fun NotificationsScreen() {

    val notifications = listOf(

        NotificationItem(
            title = "Possible Match Found",
            message = "A laptop matching your report has been found in the Main Library.",
            time = "5 minutes ago",
            isRead = false
        ),

        NotificationItem(
            title = "Claim Approved",
            message = "Your claim for Student ID has been approved.",
            time = "Yesterday",
            isRead = true
        ),

        NotificationItem(
            title = "New Found Item",
            message = "Someone reported finding a black backpack.",
            time = "2 days ago",
            isRead = true
        )

    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item {

            Text(
                text = "Notifications",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

        }

        items(notifications) { notification ->

            NotificationCard(
                title = notification.title,
                message = notification.message,
                time = notification.time,
                isRead = notification.isRead,
                onClick = {
                    // Open notification later
                }
            )

        }

    }

}