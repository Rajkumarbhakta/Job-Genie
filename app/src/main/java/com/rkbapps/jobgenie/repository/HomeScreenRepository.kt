package com.rkbapps.jobgenie.repository

import com.rkbapps.jobgenie.api.JobListingAPI
import com.rkbapps.jobgenie.model.JobList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class HomeScreenRepository @Inject constructor(
    private val api: JobListingAPI
){
    val _jobListing = MutableStateFlow<JobList>(JobList(0, emptyList(), false, 0, 0))

    val jobListing : StateFlow<JobList>
        get() = _jobListing


    suspend fun getJobListings(){
        val response = api.getJobListings()
        if(response.isSuccessful){
            _jobListing.value = response.body()!!
        }

    }





}