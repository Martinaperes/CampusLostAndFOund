package com.example.campuslostandfound.screens.help

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Help
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.screens.help.components.FAQItem

data class FAQ(
    val question: String,
    val answer: String
)

@Composable
fun HelpScreen() {

    val faqs = listOf(

        FAQ(
            "How do I report a lost item?",
            "Open the Report Lost page, complete the form and submit it."
        ),

        FAQ(
            "How do I claim an item?",
            "Open the item details and complete the claim form with accurate ownership information."
        ),

        FAQ(
            "How long are found items kept?",
            "Items are stored according to university policy before being handed over to the administration."
        ),

        FAQ(
            "What happens if multiple students claim the same item?",
            "The system verifies ownership using the information provided before releasing the item."
        ),

        FAQ(
            "Can I edit my report?",
            "Yes. Open My Reports and select the report you want to update."
        )

    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item {

            Icon(
                imageVector = Icons.Default.Help,
                contentDescription = null
            )

        }

        item {

            Text(
                text = "Help & FAQ",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

        }

        items(faqs) {

            FAQItem(
                question = it.question,
                answer = it.answer
            )

        }

    }

}