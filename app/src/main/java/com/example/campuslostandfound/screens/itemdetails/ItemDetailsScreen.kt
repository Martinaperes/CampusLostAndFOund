package com.example.campuslostandfound.screens.itemdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.R
import com.example.campuslostandfound.screens.itemdetails.components.DetailRow
import com.example.campuslostandfound.screens.reportlost.components.SubmitButton


@Composable
fun ItemDetailsScreen(){
    LazyColumn(
    modifier=Modifier.fillMaxSize(),
    contentPadding= PaddingValues(16.dp)
    ){
        item{
            Card(
                shape = RoundedCornerShape(20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.Image,
                            contentDescription = "Item Image",
                            modifier = Modifier.size(64.dp)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text("Image will appear here")
                    }
                }
            }
        }
        item{
            Spacer(modifier = Modifier.height(24.dp))
        }
        item{
            Text(
                text="HP Laptop",
                style=MaterialTheme.typography.headlineSmall
            )
        }
        item {
            Spacer(modifier=Modifier.height(20.dp))
        }
        item{
            DetailRow(
                label="Category",
                value="Electronics"
            )
        }
        item{
            Spacer(modifier = Modifier.height(16.dp))
        }

        item{
            DetailRow(
                label="Location Found",
                value = "Main Library"
            )
        }
        item {
            Spacer(modifier=Modifier.height(16.dp))
        }
        item {
            DetailRow(
                label="Date Found",
                value = "30 July 2026"
            )
        }
        item {
            Spacer(modifier=Modifier.height(16.dp))
        }
        item {
            DetailRow(
                label="Status",
                value="Available"
            )
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
        item {
            Text(
                text="Description",
                style = MaterialTheme.typography.titleMedium
            )
        }
        item {
            Spacer(modifier=Modifier.height(8.dp))
        }
        item {
            Text(
                text="Black HP Elitebook with a blue sticker on the cover.The laptop was found in good condition and appears to be working.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
        item {
            Spacer(modifier=Modifier.height(32.dp))
        }
        item {
            SubmitButton(
                text="Claim item",
                onClick={
                    //Navigate to ClaimItemScreem later
                }
            )
        }
        item {
            Spacer(modifier=Modifier.height(24.dp))
        }
    }
}