package com.example.campuslostandfound.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.campuslostandfound.screens.settings.components.SettingsItem

@Composable
fun SettingsScreen(
    navController: NavController
) {

    val settings = listOf(
        Pair(Icons.Default.Person, "Edit Profile"),
        Pair(Icons.Default.Notifications, "Notifications"),
        Pair(Icons.Default.DarkMode, "Dark Mode"),
        Pair(Icons.Default.PrivacyTip, "Privacy Policy"),
        Pair(Icons.Default.Info, "About"),
        Pair(Icons.AutoMirrored.Filled.Logout, "Logout")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        item {
            Text(
                text = "Settings",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }

        items(settings) { item ->

            SettingsItem(
                icon = item.first,
                title = item.second,
                onClick = {
                    // We'll connect these later
                }
            )

        }

    }
}