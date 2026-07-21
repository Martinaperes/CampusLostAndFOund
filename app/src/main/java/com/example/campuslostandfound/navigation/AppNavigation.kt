package com.example.campuslostandfound.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.campuslostandfound.screens.splash.SplashScreen
import com.example.campuslostandfound.screens.login.LoginScreen
import com.example.campuslostandfound.screens.register.RegisterScreen
import com.example.campuslostandfound.screens.home.HomeScreen
import com.example.campuslostandfound.screens.home.components.BottomNavigationBar
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val backStackEntry=navController.currentBackStackEntryAsState()
    val currentRoute=backStackEntry.value?.destination?.route

    Scaffold(
        bottomBar = {
            if(
                currentRoute== Routes.HOME||
                currentRoute== Routes.PROFILE
            ){
                BottomNavigationBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.REGISTER,
            modifier= Modifier.padding(innerPadding)
        ) {

            composable(Routes.SPLASH) {
                SplashScreen()
            }
            composable(Routes.LOGIN) {
                LoginScreen(navController)
            }
            composable(Routes.REGISTER) {
                RegisterScreen(navController)
            }
            composable(Routes.HOME) {
                HomeScreen(navController)
            }

        }
    }
}