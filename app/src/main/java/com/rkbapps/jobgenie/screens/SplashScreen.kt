package com.rkbapps.jobgenie.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.firebase.auth.FirebaseAuth
import com.rkbapps.jobgenie.R
import com.rkbapps.jobgenie.navigation.NavigationRoute
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.splash_screen_animation))
    val splashAnimationState =
        animateLottieCompositionAsState(composition = composition)
    LaunchedEffect(key1 = Unit) {
        delay(2000L)
        if (FirebaseAuth.getInstance().currentUser == null) {
            navController.navigate(NavigationRoute.Welcome.route) {
                popUpTo(NavigationRoute.Splash.route) {
                    inclusive = true
                }
            }
        } else {
            navController.navigate(NavigationRoute.MainScreen.route) {
                popUpTo(NavigationRoute.Splash.route) {
                    inclusive = true
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .fillMaxSize()
                .weight(0.4f)
        ) {
            Text(
                text = "Job Genie",
                fontSize = 30.sp
            )

            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}