package com.example.campuslostandfound.screens.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.navigation.Routes
import com.example.campuslostandfound.ui.theme.PrimaryGreen
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Assignment
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.draw.alpha
import androidx.compose.material.icons.filled.Assignment

@Composable
fun DashboardSection(
    navController: NavController
) {
    Column() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = PrimaryGreen
            ),
            shape = RoundedCornerShape(20.dp),
            onClick = {
                navController.navigate(Routes.REPORT_LOST)
            }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column{
                    Text(
                        text="Report Lost Item",
                        color=Color.White,
                        style= MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text="Start a report for an item you've misplaced.",
                        color=Color.White.copy(alpha = 0.9f)
                    )
                }
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Report Lost",
                    tint=Color.White,
                    modifier = Modifier.size(48.dp)
                )
            }
        }

        Row(
            modifier= Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ){
            Card(
                modifier = Modifier.weight(1f),
                shape=RoundedCornerShape(16.dp),
                onClick={
                    navController.navigate(Routes.FOUND_ITEMS)
                }
            ){
                Column(modifier = Modifier.padding(20.dp)){
                    Icon(
                        imageVector = Icons.Default.Inventory,
                        contentDescription = "Items found",
                        tint=PrimaryGreen
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text="Browse",
                        style= MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text="Found Items"
                    )
                }
            }
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(16.dp),
                onClick = {
                    navController.navigate(Routes.MY_REPORTS)
                }
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Assignment,
                        contentDescription = "My Reports",
                        tint = PrimaryGreen
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "My Reports",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "View your reports"
                    )
                }
            }
        }
    }

}