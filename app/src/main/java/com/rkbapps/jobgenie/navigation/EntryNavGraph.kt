package com.rkbapps.jobgenie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rkbapps.jobgenie.screens.HomeScreen
import com.rkbapps.jobgenie.screens.LoginScreen
import com.rkbapps.jobgenie.screens.RegistrationScreen
import com.rkbapps.jobgenie.screens.SplashScreen
import com.rkbapps.jobgenie.screens.WelcomeScreen

@Composable
fun EntryNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationRoute.Splash.route) {
        composable(route = NavigationRoute.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = NavigationRoute.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = NavigationRoute.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = NavigationRoute.Register.route) {
            RegistrationScreen(navController = navController)
        }
        composable(route = NavigationRoute.MainScreen.route){
            HomeScreen()
        }
    }



}