package com.example.campuslostandfound.screens.notifications.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.ui.theme.PrimaryGreen

@Composable
fun NotificationCard(
    title: String,
    message: String,
    time: String,
    isRead: Boolean,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(2.dp)
    ) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {

            if (!isRead) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(
                            PrimaryGreen,
                            CircleShape
                        )
                )

                Spacer(modifier = Modifier.width(12.dp))
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = time,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }

        }

    }
}