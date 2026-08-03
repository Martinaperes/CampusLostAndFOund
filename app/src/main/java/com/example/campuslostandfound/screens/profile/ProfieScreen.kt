package com.example.campuslostandfound.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.campuslostandfound.screens.profile.components.ProfileHeader
import com.example.campuslostandfound.screens.profile.components.ProfileMenuItem

@Composable
fun ProfileScreen(
    navController: NavController
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {

        item {
            Text(
                text = "Profile",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            ProfileHeader(
                name = "Peres Martina",
                registrationNumber = "SCCJ/00632/2023",
                department = "Information Technology"
            )
        }

        item {
            Spacer(modifier = Modifier.height(32.dp))
        }

        item {
            ProfileMenuItem(
                icon = Icons.Default.Description,
                title = "My Reports",
                onClick = {
                    // Navigate later
                }
            )
        }

        item {
            ProfileMenuItem(
                icon = Icons.Default.Settings,
                title = "Settings",
                onClick = {
                    // Navigate later
                }
            )
        }

        item {
            ProfileMenuItem(
                icon = Icons.AutoMirrored.Filled.Logout,
                title = "Logout",
                onClick = {
                    // Logout later
                }
            )
        }
    }
}