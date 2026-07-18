package com.example.campuslostandfound.screens.splash

import android.R
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.ui.theme.PrimaryGreen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.campuslostandfound.ui.theme.PrimaryGreen

@Composable
fun SplashScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Inventory,
            contentDescription = "App Logo",
            tint = PrimaryGreen,
            modifier = Modifier.size(90.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Campus Lost & Found",
            style = MaterialTheme.typography.headlineMedium,
            color = PrimaryGreen
        )
        Spacer(modifier=Modifier.height(16.dp))
        Text(
            text="Helping students reconnect\nwith their belongings.",
            style=MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier=Modifier.height(16.dp))
        CircularProgressIndicator(
            color = PrimaryGreen
        )

    }

}