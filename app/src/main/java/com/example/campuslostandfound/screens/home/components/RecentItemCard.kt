package com.example.campuslostandfound.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RecentItemCard(
    itemName:String,
    location:String,
    date:String,
    onClick:()->Unit
){
    Card(
        modifier= Modifier
            .fillMaxWidth()
            .clickable{
                onClick()
            },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ){
        Column{
            Box(
                modifier= Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector = Icons.Default.Image,
                    contentDescription = "Item Image"
                )
            }
            Column(
                modifier = Modifier.padding(16.dp)
            ){
                Text(
                    text=itemName,
                    style= MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        Icons.Default.LocationOn,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(6.dp))

                    Text(location)
                }
                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        Icons.Default.Schedule,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(6.dp))

                    Text(date)
                }
            }
        }
    }
}