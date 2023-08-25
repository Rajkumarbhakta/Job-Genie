package com.rkbapps.jobgenie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rkbapps.jobgenie.model.JobList
import com.rkbapps.jobgenie.repository.HomeScreenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repository: HomeScreenRepository) :
    ViewModel() {

    val jobListing: StateFlow<JobList>
        get() = repository.jobListing

    init {
        viewModelScope.launch {
            repository.getJobListings()
        }
    }

    suspend fun getJobListings() {
        repository.getJobListings()
    }
}