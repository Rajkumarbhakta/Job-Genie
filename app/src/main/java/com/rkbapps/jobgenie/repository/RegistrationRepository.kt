package com.rkbapps.jobgenie.repository

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.rkbapps.jobgenie.api.UserAPI
import com.rkbapps.jobgenie.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class RegistrationRepository @Inject constructor(private val api: UserAPI) {

    val _status = MutableStateFlow<Boolean>(false)
    val status: StateFlow<Boolean>
        get() = _status

    val _registrationStatus = MutableStateFlow<Task<AuthResult?>?>(null)
    val registrationStatus: StateFlow<Task<AuthResult?>?>
        get() = _registrationStatus

    val _uid = MutableStateFlow<String>("")
    val uid: StateFlow<String>
        get() = _uid


    suspend fun addUserInDB(
        user: User,
    ) {
        val response = api.registerUser(user)
        if (response.isSuccessful) {
            _status.emit(true)
            Log.d("RegistrationRepository", "addUser: ${response.body()}")
        } else {
            _status.emit(false)
            Log.d("RegistrationRepository", "addUser: ${response.code()} ${response.body()}")
        }
    }

    suspend fun registerUser(email: String, password: String) {
        val task = FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
        if (task.isSuccessful) {
            _registrationStatus.emit(task)
            _uid.emit(task.result?.user?.uid.toString())
        } else {
            _registrationStatus.emit(null)
        }
    }
}