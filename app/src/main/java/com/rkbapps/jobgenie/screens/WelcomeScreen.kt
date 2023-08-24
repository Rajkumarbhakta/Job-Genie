package com.rkbapps.jobgenie.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.rkbapps.jobgenie.R

@Composable
fun WelcomeScreen() {
 val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.wel))

    Box(
         Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ){
            Column(
                    Modifier
                     .fillMaxSize()
                     .padding(top = 50.dp, start = 16.dp, end = 16.dp, bottom = 50.dp)
                   ){
                       LottieAnimation(
                        composition = composition,
                         iterations = LottieConstants.IterateForever,
                          modifier = Modifier.weight(1.0f)
                     )
                     Button(
                 onClick = {  },
                     modifier = Modifier
                    .fillMaxWidth()
                   .padding(start = 20.dp, end = 20.dp)
                  ){
                   Text(
                       text = "Registration", fontSize = 16.sp, modifier = Modifier.padding(5.dp)
                      )

                   }
                      Button(
                    onClick = {},
                      modifier = Modifier
                        .fillMaxWidth()
                         .padding(start = 20.dp, end = 20.dp, top = 16.dp)
                       ){
                           Text(
                         text = "Login", fontSize = 16.sp, modifier = Modifier.padding(5.dp)
                          )

             }


          }

         }
              }
@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
 WelcomeScreen()
}