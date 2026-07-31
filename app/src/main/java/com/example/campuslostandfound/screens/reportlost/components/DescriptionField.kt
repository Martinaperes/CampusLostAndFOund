package com.example.campuslostandfound.screens.reportlost.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DescriptionField(
    description: String,
    onDescriptionChange: (String) -> Unit,
    label: String = "Description",
    placeholder: String = "Enter description..."
) {
    OutlinedTextField(
        value = description,
        onValueChange = onDescriptionChange,
        label = {
            Text(label)
        },
        placeholder = {
            Text(placeholder)
        },
        modifier = Modifier.fillMaxWidth(),
        minLines = 4,
        maxLines = 6
    )
}