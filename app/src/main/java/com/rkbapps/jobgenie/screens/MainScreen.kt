package com.rkbapps.jobgenie.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.rkbapps.jobgenie.R
import com.rkbapps.jobgenie.navigation.BottomNavigationItem
import com.rkbapps.jobgenie.navigation.MainNavGraph
import com.rkbapps.jobgenie.navigation.NavigationRoute

@Composable
fun MainScreen(mainNavController: NavHostController) {
    val currentUser = FirebaseAuth.getInstance().currentUser
    val navController = rememberNavController()
    val appBarTittle = remember { mutableStateOf("Job Genie") }
    val showLogOut = remember { mutableStateOf(false) }
    val items = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Job,
        BottomNavigationItem.Profile
    )
    Scaffold(topBar = {
        TopBar(
            appBarTitle = appBarTittle,
            navController = navController,
            items = items,
            showLogOut = showLogOut,
            mainNavController = mainNavController
        )
    }, bottomBar = {
        BottomNavigation(items = items, navController = navController)
    }) { innerPadding ->
        MainNavGraph(
            navController = navController,
            innerPadding = innerPadding,
            applicationTitle = appBarTittle,
            showLogOut = showLogOut,
        )
    }
}

@Composable
fun TopBar(
    appBarTitle: MutableState<String>,
    navController: NavHostController,
    items: List<BottomNavigationItem>,
    showLogOut: MutableState<Boolean>,
    mainNavController: NavHostController,
) {
    val context = LocalContext.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val destination = items.any { it.route == currentDestination?.route }
    if (destination) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = appBarTitle.value,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.softers_regular)),
                fontSize = 20.sp,
                modifier = Modifier.align(alignment = Alignment.CenterStart)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.align(alignment = Alignment.CenterEnd)
            ) {
                IconButton(
                    onClick = { navController.navigate(route = NavigationRoute.SearchScreen.route) },
                ) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                }
                if (showLogOut.value) {
                    IconButton(onClick = {
                        Firebase.auth.signOut()
                        Toast.makeText(context, "Log out", Toast.LENGTH_SHORT).show()
                        mainNavController.navigate(route = NavigationRoute.Welcome.route) {
                            popUpTo(0) {
                                inclusive = true
                            }
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Logout, contentDescription = "logout")
                    }
                }
            }
        }
    }
}