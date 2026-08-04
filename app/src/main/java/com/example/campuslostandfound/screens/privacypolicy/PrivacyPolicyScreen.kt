package com.example.campuslostandfound.screens.privacypolicy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class PolicySection(
    val title: String,
    val content: String
)

@Composable
fun PrivacyPolicyScreen() {

    val policy = listOf(

        PolicySection(
            "Information We Collect",
            "We collect your name, registration number, department, phone number, email address and item reports to help identify ownership."
        ),

        PolicySection(
            "How We Use Your Information",
            "Your information is only used to match lost and found items, verify ownership and notify you of updates."
        ),

        PolicySection(
            "Data Protection",
            "Your personal information is securely stored and will not be shared with unauthorized persons."
        ),

        PolicySection(
            "Your Responsibility",
            "Please provide accurate information when reporting or claiming an item. False claims may result in disciplinary action."
        )

    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.Start
    ) {

        item {

            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "Privacy"
            )

        }

        item {

            Text(
                text = "Privacy Policy",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

        }

        items(policy) { section ->

            Text(
                text = section.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = section.content,
                style = MaterialTheme.typography.bodyLarge
            )

        }

    }

}