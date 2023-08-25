package com.rkbapps.jobgenie.api

import com.rkbapps.jobgenie.model.AddUser
import com.rkbapps.jobgenie.model.User
import com.rkbapps.jobgenie.model.UserALLData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface UserAPI {

    @POST("users/add")
    suspend fun registerUser(@Body user: User): Response<AddUser>

    @POST("users/login")
    suspend fun loginUser(
        @Query("email") email: String,
        @Query("password") password: String,
    ): Response<AddUser>

    @GET("users/uid/{uid}")
    suspend fun getUser(@Query("uid") uid: String): Response<User>

    @GET("users/data/{id]")
    suspend fun getUserData(@Query("id") id: Long): Response<UserALLData>

}