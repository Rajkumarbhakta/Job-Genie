package com.rkbapps.jobgenie.repository

import com.rkbapps.jobgenie.api.UserAPI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val api: UserAPI,
) {
    val _status = MutableStateFlow<Boolean>(false)

    val status: StateFlow<Boolean>
        get() = _status

    suspend fun loginUser(email: String, password: String) {
        val response = api.loginUser(email, password)
        if (response.isSuccessful) {
            _status.emit(true)
            //Log.d("LoginRepository", "loginUser: ${response.body()}")
        } else {
            _status.emit(false)
            //Log.d("LoginRepository", "loginUser: ${response.body()}")
        }
    }
}