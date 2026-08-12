package com.example.campuslostandfound.screens.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.campuslostandfound.screens.home.components.CategoriesSection
import com.example.campuslostandfound.screens.home.components.DashboardSection
import com.example.campuslostandfound.screens.home.components.HeroSection
import com.example.campuslostandfound.screens.home.components.RecentItem
import com.example.campuslostandfound.screens.home.components.RecentItemCard
import com.example.campuslostandfound.screens.home.components.RecentItemsSection
import com.example.campuslostandfound.screens.home.components.SearchBar
import com.example.campuslostandfound.screens.home.components.TopBar
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.campuslostandfound.data.session.SessionManager
import com.example.campuslostandfound.firebase.AuthRepository
import com.example.campuslostandfound.navigation.Routes

@Composable
fun HomeScreen(navController: NavController) {

    val context = LocalContext.current

    val sessionManager = remember {
        SessionManager(context)
    }

    val authRepository = remember {
        AuthRepository()
    }
    val recentItems = listOf(
        RecentItem(
            itemName = "HP Laptop",
            location = "Main Library",
            date = "Yesterday"
        ),
        RecentItem(
            itemName = "Student ID",
            location = "Engineering Block",
            date = "Today"
        ),
        RecentItem(
            itemName = "Backpack",
            location = "Cafeteria",
            date = "2 days ago"
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        item {
            TopBar(
                onLogout = {

                    authRepository.logout()

                    sessionManager.clearSession()

                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.HOME) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        item {
            HeroSection(
                name = "Martina"
            )
        }

        item {
            SearchBar()
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            DashboardSection(
                navController = navController
            )
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            CategoriesSection()
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            RecentItemsSection()
        }

        items(recentItems) { item ->

            RecentItemCard(
                itemName = item.itemName,
                location = item.location,
                date = item.date,
                onClick = {
                    // Navigate to item details later
                }
            )

            Spacer(modifier = Modifier.height(12.dp))
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}