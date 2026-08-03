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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.getValue
import androidx.compose.material3.NavigationBarItem

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
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    NavigationBar() {
        items.forEach {
            item->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                    }
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

