package com.rkbapps.jobgenie.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.rkbapps.jobgenie.R
import com.rkbapps.jobgenie.navigation.BottomNavigationItem
import com.rkbapps.jobgenie.navigation.MainNavGraph
import com.rkbapps.jobgenie.navigation.NavigationRoute

@Composable
fun MainScreen() {
    val currentUser = FirebaseAuth.getInstance().currentUser
    val navController = rememberNavController()
    val appBarTittle = remember { mutableStateOf("Job Genie") }
    val items = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Job,
        BottomNavigationItem.Profile
    )
    Scaffold(topBar = {
        TopBar(appBarTitle = appBarTittle, navController = navController, items = items)
    }, bottomBar = {
        BottomNavigation(items = items, navController = navController)
    }) { innerPadding ->
        MainNavGraph(
            navController = navController,
            innerPadding = innerPadding,
            applicationTitle = appBarTittle
        )
    }
}

@Composable
fun TopBar(
    appBarTitle: MutableState<String>,
    navController: NavHostController,
    items: List<BottomNavigationItem>,
) {
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
            IconButton(
                onClick = { navController.navigate(route = NavigationRoute.SearchScreen.route) },
                modifier = Modifier.align(alignment = Alignment.CenterEnd)
            ) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
            }
        }
    }
}