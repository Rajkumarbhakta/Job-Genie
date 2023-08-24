package com.rkbapps.jobgenie.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen() {

    val currentUser = FirebaseAuth.getInstance().currentUser

    Scaffold(topBar = { }, bottomBar = {
    }) { innerPadding ->
        Surface(Modifier.padding(innerPadding)) {
            Text(text = currentUser?.email.toString())
        }
    }

}