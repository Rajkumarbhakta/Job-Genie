package com.rkbapps.jobgenie.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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


}@Composable
fun JobItem(){
    Column(modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Card(modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(10.dp) ) {
            Column(modifier=Modifier.padding(16.dp)) {
                Text(text = "NEW JOURNEY", fontSize = 30.sp, color = Color.Blue)
                Text(text = "Android", fontSize = 20.sp, color = Color.Black)
                Text(text = "Located at:Sector V", fontSize = 17.sp)
                Text(text = "10/08/2023", fontSize = 17.sp)


            }

        }
    }
}
