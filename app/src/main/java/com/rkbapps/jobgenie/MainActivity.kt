package com.rkbapps.jobgenie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.rkbapps.jobgenie.navigation.EntryNavGraph
import com.rkbapps.jobgenie.screens.HomeScreen
import com.rkbapps.jobgenie.screens.MainScreen
import com.rkbapps.jobgenie.ui.theme.JobGenieTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobGenieTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EntryNavGraph(navController = rememberNavController())
                    //HomeScreen()
                }
            }
        }
    }
}
