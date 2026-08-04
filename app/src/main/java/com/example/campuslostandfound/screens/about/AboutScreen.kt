package com.example.campuslostandfound.screens.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AboutScreen() {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {

            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "About",
                tint = MaterialTheme.colorScheme.primary
            )

        }

        item {

            Text(
                text = "Campus Lost & Found",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

        }


        item {

            Text(
                text = "Campus Lost & Found is a smart mobile application designed to help students report lost items, report found items, search available items, and securely claim their belongings through an easy verification process.",
                style = MaterialTheme.typography.bodyLarge
            )

        }

        item {

            Text(
                text = "Developed by",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

        }

        item {

            Text(
                text = "Peres Martina\nTechnical University of Kenya",
                style = MaterialTheme.typography.bodyLarge
            )

        }

        item {

            Text(
                text = "© 2026 Campus Lost & Found",
                style = MaterialTheme.typography.bodySmall
            )

        }
        item {

            Text(
                text = "Version 1.0.0",
                style = MaterialTheme.typography.titleMedium
            )

        }

    }

}