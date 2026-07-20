package com.example.campuslostandfound.screens.home.components
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backpack
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Devices
import androidx.compose.material.icons.filled.Key
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
data class Category(
    val title:String,
    val icon:androidx.compose.ui.graphics.vector.ImageVector
)
@Composable
fun CategoriesSection(){
    val categories=listOf(
        Category("Documents",Icons.Default.Description),
        Category("Keys", Icons.Default.Key),
        Category("Electronics", Icons.Default.Devices),
        Category("Bags", Icons.Default.Backpack)

    )
    Column(
        modifier=Modifier.padding(top=24.dp)
    ) {
        Text(
            text="Browse Categories",
            style=MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(horizontal=16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal=16.dp)
        ){
            items(categories){category->
                CategoryCard(
                    title = category.title,
                    icon=category.icon,
                    onClick={
                        //filter by category later
                    }
                )
            }
        }
    }
}
