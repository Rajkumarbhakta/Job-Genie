package com.rkbapps.jobgenie.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.firebase.auth.FirebaseAuth
import com.rkbapps.jobgenie.R
import com.rkbapps.jobgenie.model.User
import com.rkbapps.jobgenie.navigation.NavigationRoute
import com.rkbapps.jobgenie.viewmodel.RegistrationViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(navController: NavHostController) {
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

    val confirmPasswordVisibility = remember { mutableStateOf(false) }
    val passwordVisibility = remember { mutableStateOf(false) }

    val context = LocalContext.current
    val viewModel: RegistrationViewModel = hiltViewModel()
    val status = viewModel.status.collectAsState()



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
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Go,
                    keyboardType = KeyboardType.Text
                ),
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
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Go,
                    keyboardType = KeyboardType.Text
                ),
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
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Go,
                    keyboardType = KeyboardType.Email
                ),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                placeholder = {
                    Text(text = "Password")
                }, label = {
                    Text(text = "Password")
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Go,
                    keyboardType = KeyboardType.Password
                ),
                modifier = Modifier.fillMaxWidth(), trailingIcon = {
                    if (password.value.isNotEmpty()) {
                        IconButton(onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        }) {
                            Icon(
                                imageVector = if (passwordVisibility.value) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = ""
                            )
                        }
                    }
                }
            )

            OutlinedTextField(
                value = confirmPassword.value,
                onValueChange = {
                    confirmPassword.value = it
                },
                visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                placeholder = {
                    Text(text = "Confirm Password")
                }, label = {
                    Text(text = "Confirm Password")
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                ),
                modifier = Modifier.fillMaxWidth(), trailingIcon = {
                    if (confirmPassword.value.isNotEmpty()) {
                        IconButton(onClick = {
                            confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                        }) {
                            Icon(
                                imageVector = if (confirmPasswordVisibility.value) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = ""
                            )
                        }
                    }
                }
            )

            Button(
                onClick = {
                    loading.value = true
                    if (checkForm(
                            firstName.value,
                            lastName.value,
                            email.value
                        ) && checkPassword(password.value, confirmPassword.value)
                    ) {
                        FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                            email.value.trim(),
                            confirmPassword.value.trim()
                        ).addOnSuccessListener { authResult ->
                            val firebaseId = authResult.user?.uid
                            Log.d("RegistrationScreen", "firebaseId: $firebaseId")
                            if (!firebaseId.isNullOrEmpty()) {
                                viewModel.addUser(
                                    User(
                                        firstName = firstName.value.trim(),
                                        lastName = lastName.value.trim(),
                                        email = email.value.trim(),
                                        uid = firebaseId,
                                        password = confirmPassword.value.trim()
                                    )
                                )
                            } else {
                                loading.value = false
                                Toast.makeText(
                                    context,
                                    "Registration Failed",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }.addOnFailureListener {
                            loading.value = false
                            Toast.makeText(context, "Registration Failed", Toast.LENGTH_SHORT)
                                .show()
                        }
                    } else {
                        loading.value = false
                        Toast.makeText(context, "Please fill properly", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Register")
                    if (loading.value) {
                        Spacer(modifier = Modifier.size(10.dp))
                        CircularProgressIndicator(
                            modifier = Modifier.size(15.dp),
                            color = MaterialTheme.colorScheme.onPrimary,
                            strokeWidth = 2.dp,
                        )
                    }
                }
            }
            if (status.value) {
                loading.value = false
                navController.navigate(route = NavigationRoute.MainScreen.route) {
                    popUpTo(0)
                }
            }
        }

    }
}


fun checkForm(
    firstName: String,
    lastName: String,
    email: String,
): Boolean {
    if (firstName.trim().isEmpty() || lastName.trim().isEmpty() || email.trim()
            .isEmpty()
    ) {
        return false
    }
    return true
}

fun checkPassword(password: String, confirmPassword: String): Boolean {
    if (password.trim() != confirmPassword.trim() && confirmPassword.trim().length < 8) {
        return false
    }
    return true
}