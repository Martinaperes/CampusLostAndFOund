package com.example.campuslostandfound.screens.reportfound

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.components.CustomTextField
import com.example.campuslostandfound.screens.reportlost.components.CategoryDropdown
import com.example.campuslostandfound.screens.reportlost.components.DatePickerField
import com.example.campuslostandfound.screens.reportlost.components.DescriptionField
import com.example.campuslostandfound.screens.reportlost.components.ImagePickerCard
import com.example.campuslostandfound.screens.reportlost.components.SubmitButton

@Composable
fun ReportFoundScreen(){
    var itemName by remember{
        mutableStateOf("")
    }
    var selectedCategory by remember {
        mutableStateOf("")
    }
    var location by remember {
        mutableStateOf("")
    }
    var selectedDate by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    var registrationNumber by remember{
        mutableStateOf("")
    }
    var studentName by remember {
        mutableStateOf("")
    }
    var department by remember {
        mutableStateOf("")
    }
    LazyColumn(
        modifier=Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item{
            Text(
                text="Report Found Item",
                style=MaterialTheme.typography.headlineMedium
            )
        }
        item{
            Spacer(modifier=Modifier.height(24.dp))
        }
        item{
            CustomTextField(
                value=itemName,
                onValueChange = {
                    itemName=it
                },
                label = "Item Name",
                placeholder = "e.g Student ID"
            )
        }
        item {
            Spacer(modifier=Modifier.height(16.dp))
        }
        item {
            CategoryDropdown(
                selectedCategory = selectedCategory,
                onCategorySelected = {
                    selectedCategory = it
                }
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            CustomTextField(
                value=location,
                onValueChange = {
                    location=it
                },
                label = "Location Found",
                placeholder = "E.g library"
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item{
            DatePickerField(
                selectedDate=selectedDate,
                onDateSelected = {
                    selectedDate=it
                }
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            ImagePickerCard()
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            DescriptionField(
                description = description,
                onDescriptionChange = {
                    description = it
                },
                label="Description",
                placeholder = "Describe the found item..."
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            CustomTextField(
                value=registrationNumber,
                onValueChange = {
                    registrationNumber=it
                },
                label = "Registration Number",
                placeholder = "Enter your registration number"
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            CustomTextField(
                value=studentName,
                onValueChange = {
                    studentName=it
                },
                label = "Student Name",
                placeholder = "Enter your name"
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            CustomTextField(
                value=department,
                onValueChange = {
                    department=it
                },
                label = "Department",
                placeholder = "Enter your department"
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            SubmitButton(
                text="Submit Report",
                onClick = {
                    //Add validation and firebase later
                }
            )
        }





    }
}