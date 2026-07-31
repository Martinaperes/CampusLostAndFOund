package com.example.campuslostandfound.screens.itemdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.R


@Composable
fun ItemDetailsScreen(){
    LazyColumn(
    modifier=Modifier.fillMaxSize(),
    contentPadding= PaddingValues(16.dp)
    ){
        item{
            Card(
                shape= RoundedCornerShape(20.dp)
            ){
                Image(
                    painter=painterResource(id=R.drawable.placeholder_item),
                    contentDescription = "Found Item",
                    modifier=Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
        item{
            Spacer(modifier = Modifier.height(20.dp))
        }
        item{
            //item information
        }
        item {
            //spacer
        }
        item{
            //description
        }
        item{
            //spacer
        }

        item{
            //claim button
        }
    }
}