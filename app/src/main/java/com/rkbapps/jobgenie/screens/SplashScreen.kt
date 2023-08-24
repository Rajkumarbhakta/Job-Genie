package com.rkbapps.jobgenie.screens

import android.window.SplashScreen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.rkbapps.jobgenie.R

@Composable
fun SplashScreen(){
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.animation_welcome))
    val splashAnimationState =
        animateLottieCompositionAsState(composition = composition)
    Column(modifier= Modifier
        .fillMaxSize()
        .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ){
        Box(contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .weight(0.4f)) {
            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever
            )


        }


    }


}