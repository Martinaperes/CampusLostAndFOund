package com.example.campuslostandfound.screens.reportlost.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DescriptionField(
    description:String,
    onDescriptionChange:(String)->Unit
){
    OutlinedTextField(
        value = description,
        onValueChange = onDescriptionChange,
        label={
            Text("Description")
        },
        placeholder = {
            Text("Describe the lost item ...")
        },
        modifier = Modifier.fillMaxWidth(),
        minLines=4,
        maxLines = 6
    )
}