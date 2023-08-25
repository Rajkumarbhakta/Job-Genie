package com.rkbapps.jobgenie.module

import com.rkbapps.jobgenie.api.JobListingAPI
import com.rkbapps.jobgenie.api.UserAPI
import com.rkbapps.jobgenie.util.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {


    @Singleton
    @Provides
    fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getUserAPi(retrofit: Retrofit): UserAPI {
        return retrofit.create(UserAPI::class.java)
    }

    @Singleton
    @Provides
    fun getJobListingApi(retrofit: Retrofit): JobListingAPI {
        return retrofit.create(JobListingAPI::class.java)
    }


}