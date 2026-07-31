package com.example.campuslostandfound.screens.claimitem


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.components.CustomTextField
import com.example.campuslostandfound.screens.reportlost.components.DescriptionField
import com.example.campuslostandfound.screens.reportlost.components.ImagePickerCard
import com.example.campuslostandfound.screens.reportlost.components.SubmitButton


@Composable
fun ClaimItemScreen(){
    var registrationNumber by remember {
        mutableStateOf("")
    }

    var studentName by remember {
        mutableStateOf("")
    }

    var department by remember {
        mutableStateOf("")
    }

    var phoneNumber by remember {
        mutableStateOf("")
    }

    var serialNumber by remember {
        mutableStateOf("")
    }
    var ownershipDescription by remember {
        mutableStateOf(" ")
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Text(
                text="Claim Item",
                style= MaterialTheme.typography.headlineMedium
            )
        }
        item {
            Spacer(modifier=Modifier.height(8.dp))
        }
        item {
            Text(
                text="Provide accurate information to help us verify ownership before the item is released.",
                style=MaterialTheme.typography.bodyMedium
            )
        }
        item{
            Spacer(modifier=Modifier.height(24.dp))
        }
        item {
            CustomTextField(
                value = registrationNumber,
                onValueChange = {
                    registrationNumber=it
                },
                label="Registration Number",
                placeholder = "e.g SCCJ/00632/2023"
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            CustomTextField(
                value = studentName,
                onValueChange = {
                    studentName=it
                },
                label="Student Name",
                placeholder = "e.g Martina Peres"
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            CustomTextField(
                value = department,
                onValueChange = {
                    department=it
                },
                label="Department",
                placeholder = "e.g Computing and Information Technology"
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            CustomTextField(
                value = phoneNumber,
                onValueChange = {
                    phoneNumber=it
                },
                label="Phone number",
                placeholder = "e.g 0716052342"
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            CustomTextField(
                value = serialNumber,
                onValueChange = {
                    serialNumber=it
                },
                label="Item Serail Number(Optional)",
                placeholder = "e.g 0087-9U"
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            DescriptionField(
                description = ownershipDescription,
                onDescriptionChange = {
                    ownershipDescription=it
                },
                label = "Proof of ownership",
                placeholder = "Describe something only the owner would know about this item."
            )
        }
        item {
            Spacer(modifier=Modifier.height(24.dp))
        }
        item{
            Text(
                text="Supporting document(optional)",
                style= MaterialTheme.typography.titleMedium
            )
        }
        item {
            Spacer(modifier=Modifier.height(8.dp))
        }
        item {
            Text(
                text = "Upload a student ID, receipt, warranty card, or any document that can help verify ownership.",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            ImagePickerCard()
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            SubmitButton(
                text = "Submit Claim",
                onClick = {
                    // Validation + Firebase later
                }
            )
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }

    }
}