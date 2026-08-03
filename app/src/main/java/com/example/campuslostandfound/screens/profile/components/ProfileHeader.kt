package com.example.campuslostandfound.screens.profile.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import com.example.campuslostandfound.ui.theme.PrimaryGreen

@Composable
fun ProfileHeader(
    name:String,
    registrationNumber: String,
    department:String
){
    Column(
        modifier=Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Surface(
            modifier =Modifier.size(100.dp),
                shape=CircleShape,
                color=PrimaryGreen.copy(alpha = 0.15f)
        ) {
            Box(
                contentAlignment=Alignment.Center
            ){
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    tint=PrimaryGreen,
                    modifier = Modifier.size(60.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text=name,
            style= MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text=registrationNumber,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier=Modifier.height(4.dp))
        Text(
            text = department,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}