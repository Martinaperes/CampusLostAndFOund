package com.example.campuslostandfound.screens.reportlost.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun ImagePickerCard(){
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val launcher=rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        uri:Uri?->
        imageUri=uri
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .clickable{
                launcher.launch("image/*")
            },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
           if(imageUri!=null){
               Image(
                   painter = rememberAsyncImagePainter(imageUri),
                   contentDescription = "Selected image",
                   modifier= Modifier
                       .fillMaxSize()
                       .clip(RoundedCornerShape(20.dp))
               )}
               else{
                   Column(
                       horizontalAlignment = Alignment.CenterHorizontally
                   ){
                       Icon(
                           imageVector = Icons.Default.AddAPhoto,
                           contentDescription = "Upload Image",
                           modifier=Modifier.size(56.dp)
                       )
                       Spacer(modifier = Modifier.height(12.dp))
                       Text(
                           text = "Tap to upload image",
                           style = MaterialTheme.typography.titleMedium
                       )

                       Spacer(modifier = Modifier.height(4.dp))
                       Text(
                           text = "Add a clear photo of the lost item",
                           style = MaterialTheme.typography.bodyMedium
                       )
                   }
               }
           }
        }
    }



