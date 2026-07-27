package com.example.campuslostandfound.screens.reportlost

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.screens.reportlost.components.ImagePickerCard
import com.example.campuslostandfound.screens.reportlost.components.SubmitButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import com.example.campuslostandfound.screens.reportlost.components.ItemNameField
import com.example.campuslostandfound.components.CustomTextField
import com.example.campuslostandfound.screens.reportlost.components.CategoryDropdown
import com.example.campuslostandfound.screens.reportlost.components.DatePickerField
import com.example.campuslostandfound.screens.reportlost.components.DescriptionField

@Composable
fun ReportLostScreen() {
    var itemName by remember {
        mutableStateOf("")
    }
    var selectedCategory by remember {
        mutableStateOf("")
    }
    var selectedDate by remember{
        mutableStateOf("")
    }
    var description by remember{
        mutableStateOf("")
    }
    var location by remember{
        mutableStateOf("")
    }
    LazyColumn(
    modifier=Modifier.fillMaxSize(),
    contentPadding=androidx.compose.foundation.layout.PaddingValues(16.dp)
    ) {item{
        Text(
            text="Report Lost Item",
            style= MaterialTheme.typography.headlineMedium
        )
    }
        item {
            Spacer(modifier= Modifier.height(24.dp))
        }
        item {
        CustomTextField(
            value = itemName,
            onValueChange = {
                itemName = it
            },
            label = "Item Name",
            placeholder = "e.g Laptop"
        )}
        item{
        Spacer(modifier = Modifier.height(16.dp))}
        item{
        CategoryDropdown(
            selectedCategory = selectedCategory,
            onCategorySelected = {
                selectedCategory = it
            }
        )}
        item{
        Spacer(modifier = Modifier.height(16.dp))}
        item{
        CustomTextField(
            value=location,
            onValueChange = {
                location=it
            },
            label = "Last seen location",
            placeholder = "E.g library"
        )}
        item{
        Spacer(modifier = Modifier.height(16.dp))}
        item{
        DatePickerField(
            selectedDate=selectedDate,
            onDateSelected = {
                selectedDate=it
            }
        )}
        item{
            Spacer(modifier = Modifier.height(16.dp))}
        item{
            ImagePickerCard()
        }

        item{
        Spacer(modifier = Modifier.height(16.dp))}
        item {
            DescriptionField(
                description = description,
                onDescriptionChange = {
                    description = it
                }
            )
        }
        item{
            Spacer(modifier = Modifier.height(16.dp))}
        item {
            SubmitButton(
                onClick = {
                    //Add validation and firebase later
                }
            )
        }

    }


}