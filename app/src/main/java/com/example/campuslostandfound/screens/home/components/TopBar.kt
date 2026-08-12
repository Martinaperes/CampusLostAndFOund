package com.example.campuslostandfound.screens.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.campuslostandfound.ui.theme.PrimaryGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onLogout: () -> Unit
) {

    CenterAlignedTopAppBar(

        title = {
            Text(
                text = "Campus Lost & Found",
                style = MaterialTheme.typography.titleLarge,
                color = PrimaryGreen
            )
        },

        actions = {

            IconButton(
                onClick = onLogout
            ) {

                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "Logout",
                    tint = PrimaryGreen
                )
            }
        }
    )
}