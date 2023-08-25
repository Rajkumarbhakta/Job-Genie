package com.rkbapps.jobgenie.repository

import com.google.firebase.auth.FirebaseAuth
import com.rkbapps.jobgenie.api.UserAPI
import com.rkbapps.jobgenie.model.User
import com.rkbapps.jobgenie.model.UserALLData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ProfileScreenRepository @Inject constructor(private val userApi: UserAPI) {

    val _userData = MutableStateFlow<UserALLData?>(null)

    val userData: StateFlow<UserALLData?>
        get() = _userData

    private suspend fun getUserData(): User {
        val response = userApi.getUser(FirebaseAuth.getInstance().currentUser!!.uid)
        return response.body()!!
    }
    suspend fun getUserDetails() {
        val response = userApi.getUserData(getUserData().id!!)
        if (response.isSuccessful) {
            _userData.value = response.body()
        } else {
            _userData.value = null
        }
    }


}