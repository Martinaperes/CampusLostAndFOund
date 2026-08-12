package com.example.campuslostandfound.screens.myreports

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.data.local.DatabaseProvider
import com.example.campuslostandfound.data.local.LostFoundItemEntity
import com.example.campuslostandfound.data.repository.LostFoundRepository
import com.example.campuslostandfound.data.session.SessionManager

@Composable
fun MyReportsScreen() {

    val context = LocalContext.current

    val database = remember {
        DatabaseProvider.getDatabase(context)
    }

    val repository = remember {
        LostFoundRepository(
            database.lostFoundItemDao()
        )
    }

    val sessionManager = remember {
        SessionManager(context)
    }

    val currentUserId = sessionManager.getUserId()

    var reports by remember {
        mutableStateOf<List<LostFoundItemEntity>>(emptyList())
    }

    var isLoading by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(currentUserId) {

        if (currentUserId != -1) {

            try {

                reports = repository.getItemsByUser(currentUserId)

            } catch (exception: Exception) {

                Toast.makeText(
                    context,
                    "Failed to load reports: ${exception.message}",
                    Toast.LENGTH_LONG
                ).show()

            } finally {

                isLoading = false
            }

        } else {

            isLoading = false
        }
    }

    when {

        isLoading -> {

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Loading reports..."
                )
            }
        }

        reports.isEmpty() -> {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "No reports yet",
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(
                    text = "Your lost and found reports will appear here."
                )
            }
        }

        else -> {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                item {

                    Text(
                        text = "My Reports",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }

                items(reports) { report ->

                    ReportCard(
                        report = report
                    )
                }
            }
        }
    }
}

@Composable
private fun ReportCard(
    report: LostFoundItemEntity
) {

    Card(
        modifier = Modifier
            .padding(bottom = 12.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = report.itemName,
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = "Category: ${report.category}"
            )

            Text(
                text = "Type: ${report.type}"
            )

            Text(
                text = "Location: ${report.location}"
            )

            Text(
                text = "Date: ${report.date}"
            )

            Text(
                text = "Status: ${report.status}"
            )

            if (!report.serialNumber.isNullOrBlank()) {

                Text(
                    text = "Serial Number: ${report.serialNumber}"
                )
            }

            Text(
                text = "Description: ${report.description}"
            )
        }
    }
}