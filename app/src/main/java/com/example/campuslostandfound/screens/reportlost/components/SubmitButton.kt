package com.example.campuslostandfound.screens.reportlost.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SubmitButton(
    onClick:()->Unit
){
    Button(
        onClick=onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Submit Report")
    }
}