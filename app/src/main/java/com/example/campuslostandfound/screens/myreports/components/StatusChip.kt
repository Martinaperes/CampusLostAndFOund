package com.example.campuslostandfound.screens.myreports.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun StatusChip(
    status: String
) {

    val backgroundColor = when (status) {
        "Searching" -> Color(0xFFE8F5E9)
        "Waiting for Owner" -> Color(0xFFFFF8E1)
        "Claimed" -> Color(0xFFE3F2FD)
        "Resolved" -> Color(0xFFF3E5F5)
        else -> Color.LightGray
    }

    val textColor = when (status) {
        "Searching" -> Color(0xFF2E7D32)
        "Waiting for Owner" -> Color(0xFFF9A825)
        "Claimed" -> Color(0xFF1565C0)
        "Resolved" -> Color(0xFF6A1B9A)
        else -> Color.DarkGray
    }

    Text(
        text = status,
        color = textColor,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier
            .background(
                backgroundColor,
                RoundedCornerShape(50)
            )
            .padding(
                horizontal = 12.dp,
                vertical = 6.dp
            )
    )

}