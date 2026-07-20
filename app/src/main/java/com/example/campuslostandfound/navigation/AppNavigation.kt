package com.example.campuslostandfound.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.campuslostandfound.screens.splash.SplashScreen
import com.example.campuslostandfound.screens.login.LoginScreen
import com.example.campuslostandfound.screens.register.RegisterScreen
import com.example.campuslostandfound.screens.home.HomeScreen
@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.REGISTER
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