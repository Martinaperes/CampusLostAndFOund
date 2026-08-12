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
import androidx.navigation.NavController
import com.example.campuslostandfound.navigation.Routes
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@Composable
fun MyReportsScreen(
    navController: NavController
) {

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
    var reportToDelete by remember {
        mutableStateOf<LostFoundItemEntity?>(null)
    }

    val scope = rememberCoroutineScope()
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
                        report = report,
                        onEdit = {
                            navController.navigate(
                                "${Routes.EDIT_REPORT}/${report.itemId}"
                            )
                        },
                        onDelete = {
                            reportToDelete = report
                        }
                    )
                }
            }
        }
    }
    if (reportToDelete != null) {

        AlertDialog(
            onDismissRequest = {
                reportToDelete = null
            },

            title = {
                Text("Delete Report?")
            },

            text = {
                Text(
                    "Are you sure you want to delete " +
                            "\"${reportToDelete!!.itemName}\"? " +
                            "This action cannot be undone."
                )
            },

            confirmButton = {

                TextButton(
                    onClick = {

                        val report = reportToDelete

                        if (report != null) {

                            scope.launch {

                                try {

                                    repository.deleteItem(report)

                                    reports = reports.filter {
                                        it.itemId != report.itemId
                                    }

                                    reportToDelete = null

                                    Toast.makeText(
                                        context,
                                        "Report deleted successfully!",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                } catch (exception: Exception) {

                                    Toast.makeText(
                                        context,
                                        "Delete failed: ${exception.message}",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }
                        }
                    }
                ) {
                    Text("DELETE")
                }
            },

            dismissButton = {

                TextButton(
                    onClick = {
                        reportToDelete = null
                    }
                ) {
                    Text("CANCEL")
                }
            }
        )
    }
}

@Composable
private fun ReportCard(
    report: LostFoundItemEntity,
    onEdit: () -> Unit,
    onDelete: () -> Unit
){

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
            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Button(
                onClick = onEdit,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("EDIT REPORT")
            }
            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Button(
                onClick = onDelete,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                )
            ) {
                Text("DELETE REPORT")
            }
        }
    }
}