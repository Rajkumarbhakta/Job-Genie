package com.rkbapps.jobgenie.api

import com.rkbapps.jobgenie.model.AddUser
import com.rkbapps.jobgenie.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface JobApi {

    @POST("/api/v1/users/add")
    suspend fun addUser(@Body user: User): Response<AddUser>

}