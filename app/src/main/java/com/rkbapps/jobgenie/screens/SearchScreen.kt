package com.rkbapps.jobgenie.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.rkbapps.jobgenie.ui.theme.lightBlue


@Composable
fun SearchScreen() {
    val searchQuery = rememberSaveable {
        mutableStateOf("")
    }
    val focus = remember {
        mutableStateOf(true)
    }


    Scaffold(topBar = {
        SearchBar(searchQuery, focus) {
            if (it.isNotEmpty()) {
                //viewModel.search(it)
            }
        }
    }) { innerPadding ->

        Box(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Search Screen")
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    searchQuery: MutableState<String>,
    focus: MutableState<Boolean>,
    onSearch: (query: String) -> Unit,
) {
    TextField(
        value = searchQuery.value,
        onValueChange = {
            searchQuery.value = it
        },
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = Color.Black,
            disabledLabelColor = lightBlue,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(text = "Search here")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
            .onFocusChanged {
                focus.value = it.hasFocus
            }, keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ), keyboardActions = KeyboardActions(
            onSearch = {
                onSearch(searchQuery.value)
            }
        ),
        shape = RoundedCornerShape(30.dp),
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "")
            }
        },
        singleLine = true
    )

}