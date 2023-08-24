package com.rkbapps.jobgenie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rkbapps.jobgenie.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepository) : ViewModel() {

    val status = repository.status

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            repository.loginUser(email, password)
        }
    }

}