package com.example.campuslostandfound.screens.founditems.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FoundItemCard(
    itemName: String,
    location: String,
    date: String,
    onClick: ()-> Unit
){
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable{
                onClick()
            }
    ){
        Column(
            modifier = Modifier.padding(16.dp)
        ){
            Text(text=itemName)

            Text(text=location)

            Text(text=date)
        }
    }
}