package com.example.campuslostandfound.screens.editprofile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.components.CustomTextField
import com.example.campuslostandfound.screens.editprofile.components.ProfileImagePicker
import com.example.campuslostandfound.screens.reportlost.components.SubmitButton

@Composable
fun EditProfileScreen() {

    var fullName by remember { mutableStateOf("Peris Martina") }
    var department by remember { mutableStateOf("Information Technology") }
    var phoneNumber by remember { mutableStateOf("0712345678") }

    val registrationNumber = "BBT-01-0123/2024"
    val email = "peris@example.com"

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            Text(
                text = "Edit Profile",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            ProfileImagePicker(
                onClick = {
                    // Open gallery later
                }
            )
        }

        item {
            CustomTextField(
                value = fullName,
                onValueChange = { fullName = it },
                label = "Full Name",
                placeholder = "Enter your full name"
            )
        }

        item {
            CustomTextField(
                value = registrationNumber,
                onValueChange = {},
                label = "Registration Number",
                placeholder = "",
                enabled = false
            )
        }

        item {
            CustomTextField(
                value = department,
                onValueChange = { department = it },
                label = "Department",
                placeholder = "Enter your department"
            )
        }

        item {
            CustomTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = "Phone Number",
                placeholder = "Enter phone number"
            )
        }

        item {
            CustomTextField(
                value = email,
                onValueChange = {},
                label = "Email",
                placeholder = "",
                enabled = false
            )
        }

        item {
            SubmitButton(
                text = "Save Changes",
                onClick = {
                    // Update profile later
                }
            )
        }
    }
}