package com.rkbapps.jobgenie.api

import com.rkbapps.jobgenie.model.JobList
import retrofit2.Response
import retrofit2.http.GET

interface JobListingAPI {

    @GET("job-listings/all")
    suspend fun getJobListings(): Response<JobList>


}