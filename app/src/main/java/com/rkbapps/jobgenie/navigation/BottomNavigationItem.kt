package com.rkbapps.jobgenie.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Work
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomNavigationItem("home", "Home", Icons.Filled.Home)
    object Job : BottomNavigationItem(route = "job", title = "Job", icon = Icons.Filled.Work)
    object Profile : BottomNavigationItem(
        route = "profile",
        title = "Profile",
        icon = Icons.Filled.AccountCircle
    )
}
