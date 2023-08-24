package com.rkbapps.jobgenie.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.rkbapps.jobgenie.R
import com.rkbapps.jobgenie.viewmodel.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.login_animation))

    val viewModel: LoginViewModel = hiltViewModel()
    val status = viewModel.status.collectAsState()
    val context = LocalContext.current



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = "Login",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            textAlign = TextAlign.Center
        )
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.weight(0.4f)
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
        ) {
            OutlinedTextField(
                value = email.value, onValueChange = { email.value = it },
                label = {
                    Text(text = "Email")
                },
                placeholder = {
                    Text(text = "Email")
                },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password.value, onValueChange = { password.value = it },
                label = {
                    Text(text = "Password")
                },
                placeholder = {
                    Text(text = "Password")
                },
                modifier = Modifier.fillMaxWidth()

            )
            Button(
                onClick = {
                    if (email.value.isNotEmpty() && password.value.isNotEmpty()) {
                        viewModel.loginUser(email.value, password.value)
                        if (status.value) {
                            Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                        }
                    }


                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 16.dp)
            ) {
                Text(text = "LOGIN")
            }
        }


    }


}






