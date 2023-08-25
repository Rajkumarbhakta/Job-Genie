package com.rkbapps.jobgenie.navigation

sealed class NavigationRoute(
    val route: String,
) {
    object Splash : NavigationRoute("splash")
    object Welcome : NavigationRoute("welcome")
    object Login : NavigationRoute("login")
    object Register : NavigationRoute("register")
    object MainScreen : NavigationRoute("main_screen")
    object SearchScreen : NavigationRoute("search_screen")
}
