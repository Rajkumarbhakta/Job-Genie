package com.rkbapps.jobgenie.repository

import android.util.Log
import com.rkbapps.jobgenie.api.JobApi
import com.rkbapps.jobgenie.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class RegistrationRepository @Inject constructor(private val api: JobApi) {

    val _status = MutableStateFlow<Boolean>(false)
    val status: StateFlow<Boolean>
        get() = _status


    suspend fun addUser(
        user: User,
    ) {
        val response = api.addUser(user)
        if (response.isSuccessful){
            _status.emit(true)
            Log.d("RegistrationRepository", "addUser: ${response.body()}")
        }
        else{
            _status.emit(false)
            Log.d("RegistrationRepository", "addUser: ${response.message()}")
        }


    }


}