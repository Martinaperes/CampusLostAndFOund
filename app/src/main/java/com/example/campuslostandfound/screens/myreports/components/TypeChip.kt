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
fun TypeChip(
    type: String
) {

    val backgroundColor = if (type == "Lost") {
        Color(0xFFFFEBEE)
    } else {
        Color(0xFFE8F5E9)
    }

    val textColor = if (type == "Lost") {
        Color(0xFFC62828)
    } else {
        Color(0xFF2E7D32)
    }

    Text(
        text = type.uppercase(),
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