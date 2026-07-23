package com.example.campuslostandfound.screens.reportlost

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.campuslostandfound.screens.reportlost.components.ItemNameField
import com.example.campuslostandfound.components.CustomTextField

@Composable
fun ReportLostScreen() {
    var itemName by remember {
        mutableStateOf("")
    }
    CustomTextField(
        value = itemName,
        onValueChange = {
            itemName = it
        },
        label = "Item Name",
        placeholder = "e.g Laptop"
    )


}