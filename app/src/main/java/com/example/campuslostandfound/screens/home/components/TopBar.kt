package com.example.campuslostandfound.screens.home.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.campuslostandfound.ui.theme.PrimaryGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Campus Lost & Found",
                style = MaterialTheme.typography.titleLarge,
                color = PrimaryGreen
            )
        }
    )

}