package com.rkbapps.jobgenie.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rkbapps.jobgenie.screens.HomeScreen
import com.rkbapps.jobgenie.screens.ProfileScreen
import com.rkbapps.jobgenie.screens.SearchScreen

@Composable
fun MainNavGraph(
    navController: NavHostController,
    applicationTitle: MutableState<String>,
    innerPadding: PaddingValues,
    showLogOut: MutableState<Boolean>,
) {
    NavHost(
        navController = navController, startDestination = BottomNavigationItem.Home.route,
        modifier = Modifier.padding(paddingValues = innerPadding)
    ) {

        composable(route = BottomNavigationItem.Home.route) {
            applicationTitle.value = "Job Genie"
            showLogOut.value = false
            HomeScreen()
        }

        composable(route = BottomNavigationItem.Job.route) {
            applicationTitle.value = "Applications"
            showLogOut.value = false
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Job Page")
            }
        }

        composable(route = BottomNavigationItem.Profile.route) {
            applicationTitle.value = "Profile"
            showLogOut.value = true
            ProfileScreen(navController = navController)
        }
        composable(route = NavigationRoute.SearchScreen.route) {
            SearchScreen()
        }
    }


}