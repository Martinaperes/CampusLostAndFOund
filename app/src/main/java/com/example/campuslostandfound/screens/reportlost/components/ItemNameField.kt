package com.example.campuslostandfound.screens.reportlost.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ItemNameField(
    itemName: String,
    onItemNameChange:(String)-> Unit
){
    OutlinedTextField(
        value = itemName,
        onValueChange = onItemNameChange,
        label = {
            Text("Item Name")
        },
        placeholder = {
            Text("e.g Laptop")
        },
        modifier=Modifier.fillMaxWidth()
    )

}