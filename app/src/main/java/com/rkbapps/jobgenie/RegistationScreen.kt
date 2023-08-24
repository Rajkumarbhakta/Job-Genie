package com.rkbapps.jobgenie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen() {

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


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
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

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Register")
        }


    }


}