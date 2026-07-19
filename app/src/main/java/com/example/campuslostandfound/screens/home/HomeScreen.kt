package com.example.campuslostandfound.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.campuslostandfound.screens.home.components.GreetingSection
import com.example.campuslostandfound.screens.home.components.TopBar
@Composable
fun HomeScreen() {

    Column(
        modifier=Modifier.fillMaxSize()
    ) {
        TopBar()
        GreetingSection(
            name = "Martina"
        )
    }

    }

