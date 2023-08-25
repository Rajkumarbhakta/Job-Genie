package com.rkbapps.jobgenie.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rkbapps.jobgenie.model.User

@Composable
fun HomeScreen() {

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Add, contentDescription ="" )

        }
    }) {
//        LazyColumn(content = , modifier = Modifier.padding(it) ){
//
//
//
//        }
        Box(modifier = Modifier.padding(it))
    }


}