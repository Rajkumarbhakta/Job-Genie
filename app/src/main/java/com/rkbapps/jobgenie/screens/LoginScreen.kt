package com.rkbapps.jobgenie.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.rkbapps.jobgenie.R
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    val email= remember {
        mutableStateOf("")
    }
    val password= remember {
        mutableStateOf("")
    }
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.login_animation))
    Column(modifier= Modifier
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        
    )
    {
        OutlinedTextField(value = email.value, onValueChange ={email.value=it},
            placeholder = {
                Text(text = "Email")
            },


            modifier = Modifier.fillMaxWidth()
            )
        OutlinedTextField(value = password.value, onValueChange ={password.value=it},
            placeholder = {
                Text(text = "Password")
            },

            modifier = Modifier.fillMaxWidth()

        )
        Button(onClick = { /*TODO*/ }) {
            Text(text = "LOGIN")

            
        }
        
    }




}






