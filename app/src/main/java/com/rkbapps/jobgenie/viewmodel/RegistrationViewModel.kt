package com.rkbapps.jobgenie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.rkbapps.jobgenie.model.User
import com.rkbapps.jobgenie.repository.RegistrationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val repository: RegistrationRepository,
) : ViewModel() {

    val status: StateFlow<Boolean>
        get() = repository.status

    val registrationStatus: StateFlow<Task<AuthResult?>?>
        get() = repository.registrationStatus

    val uid: StateFlow<String>
        get() = repository.uid

    fun addUser(
        user: User,
    ) {
        viewModelScope.launch {
            repository.addUserInDB(user)
        }
    }

    fun registerUser(email: String, password: String) {
        viewModelScope.launch {
            repository.registerUser(email, password)
        }
    }
}