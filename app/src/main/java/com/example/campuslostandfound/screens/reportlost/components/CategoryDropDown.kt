package com.example.campuslostandfound.screens.reportlost.components

import androidx.compose.foundation.gestures.draggable
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDropdown(
    selectedCategory:String,
    onCategorySelected:(String)-> Unit

){
    val categories=listOf(
        "Electronics",
        "Documents",
        "Books",
        "Clothing",
        "Accessories",
        "Other"
    )
    var expanded by remember{
        mutableStateOf(false)
    }
    ExposedDropdownMenuBox(
        expanded=expanded,
        onExpandedChange = {
            expanded=!expanded
        }
    ) {
        OutlinedTextField(
            value=selectedCategory,
            onValueChange = {},
            readOnly = true,
            label={
                Text("Category")
            },
            placeholder = {
                Text("Select Category")
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded=expanded
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor()
        )
        ExposedDropdownMenu(
            expanded=expanded,
            onDismissRequest = {
                expanded=false
            }
        ) {
            categories.forEach { category->
                DropdownMenuItem(
                    text={
                        Text(category)
                    },
                    onClick = {
                        onCategorySelected(category)
                        expanded=false
                    }
                )
            }
        }
    }



}