package com.rkbapps.jobgenie.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
import com.google.firebase.auth.FirebaseAuth
import com.rkbapps.jobgenie.R
import com.rkbapps.jobgenie.model.User
import com.rkbapps.jobgenie.viewmodel.RegistrationViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.register))
    val firstName = remember {
        mutableStateOf("")
    }
    val lastName = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val confirmPassword = remember {
        mutableStateOf("")
    }

    val loading = remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    val viewModel: RegistrationViewModel = hiltViewModel()
    val status = viewModel.status.collectAsState()
    val registrationStatus = viewModel.registrationStatus.collectAsState()
    val uid = viewModel.uid.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Register",
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .weight(0.6f)
        ) {
            OutlinedTextField(
                value = firstName.value,
                onValueChange = {
                    firstName.value = it
                },
                placeholder = {
                    Text(text = "First Name")
                }, label = {
                    Text(text = "First Name")
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = lastName.value,
                onValueChange = {
                    lastName.value = it
                },
                placeholder = {
                    Text(text = "Last Name")
                }, label = {
                    Text(text = "Last Name")
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = email.value,
                onValueChange = {
                    email.value = it
                },
                placeholder = {
                    Text(text = "Email")
                },
                label = {
                    Text(text = "Email")
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                placeholder = {
                    Text(text = "Password")
                }, label = {
                    Text(text = "Password")
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = confirmPassword.value,
                onValueChange = {
                    confirmPassword.value = it
                },
                placeholder = {
                    Text(text = "Confirm Password")
                }, label = {
                    Text(text = "Confirm Password")
                },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = {
                    loading.value = true
                    if (checkForm(
                            firstName.value,
                            lastName.value,
                            email.value,
                            password.value,
                            confirmPassword.value
                        )
                    ) {
//                        viewModel.registerUser(email.value, password.value)
                        FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                            email.value,
                            password.value
                        ).addOnSuccessListener { authResult ->
                            val firebaseId = authResult.user?.uid
                            Log.d("RegistrationScreen", "firebaseId: $firebaseId")
                            if (!firebaseId.isNullOrEmpty()) {
                                viewModel.addUser(
                                    User(
                                        firstName = firstName.value,
                                        lastName = lastName.value,
                                        email = email.value,
                                        uid = firebaseId,
                                        password = password.value
                                    )
                                )
                            } else {
                                loading.value = false
                                Toast.makeText(
                                    context,
                                    "Registration Failed:UID",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }.addOnFailureListener {
                            loading.value = false
                            Toast.makeText(context, "Registration Failed", Toast.LENGTH_SHORT)
                                .show()
                        }
//                        if (registrationStatus.value!!.isSuccessful) {
//                            val firebaseId = registrationStatus.value!!.result?.user?.uid
//                            if (!firebaseId.isNullOrEmpty()) {
//                                viewModel.addUser(
//                                    User(
//                                        firstName = firstName.value,
//                                        lastName = lastName.value,
//                                        email = email.value,
//                                        uid = firebaseId,
//                                        password = password.value
//                                    )
//                                )
//                            } else {
//                                loading.value = false
//                                Toast.makeText(
//                                    context,
//                                    "Registration Failed:UID",
//                                    Toast.LENGTH_SHORT
//                                ).show()
//                            }
//                        } else {
//                            loading.value = false
//                            Toast.makeText(context, "Registration Failed", Toast.LENGTH_SHORT)
//                                .show()
//                        }
                    } else {
                        loading.value = false
                        Toast.makeText(context, "Please fill properly", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 16.dp)
            ) {
                Text(text = "Register")
            }
            if (
                loading.value
            ) {
                CircularProgressIndicator(modifier = Modifier.size(10.dp))
            }
            if (status.value) {
                Text(
                    text = "Registration Successful",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 10.dp),
                    textAlign = TextAlign.Center
                )
            }
        }

    }
}

fun checkForm(
    firstName: String,
    lastName: String,
    email: String,
    password: String,
    confirmPassword: String,
): Boolean {
    if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
        return false
    }
    if (password != confirmPassword && password.length < 8) {
        return false
    }
    return true
}