package com.example.campuslostandfound.screens.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.campuslostandfound.navigation.BottomNavItem
import com.example.campuslostandfound.navigation.Routes

@Composable
fun BottomNavigationBar(
    navController: NavController
){
    val items=listOf(
        BottomNavItem(
            title="Home",
            icon=Icons.Default.Home,
            route=Routes.HOME
        ),
        BottomNavItem(
            title="Report",
            icon=Icons.Default.Add,
            route=Routes.REPORT_LOST
        ),
        BottomNavItem(
            title="Profile",
            icon=Icons.Default.Person,
            route=Routes.PROFILE
        )

    )
    NavigationBar() {
        items.forEach {
            item->
            NavigationBarItem(
                selected=false,
                onClick = {
                    navController.navigate(item.route)
                },
                icon={
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label={
                    Text(item.title)
                }
            )
        }
    }
}

