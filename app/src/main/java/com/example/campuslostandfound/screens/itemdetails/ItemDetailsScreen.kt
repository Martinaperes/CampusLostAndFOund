package com.example.campuslostandfound.screens.itemdetails

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ItemDetailsScreen(){
    LazyColumn(
    modifier=Modifier.fillMaxSize(),
    contentPadding= PaddingValues(16.dp)
    ){
        item{
            //image
        }
        item{
            //spacer
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