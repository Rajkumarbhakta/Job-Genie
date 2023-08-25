package com.rkbapps.jobgenie.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rkbapps.jobgenie.model.UserALLData
import com.rkbapps.jobgenie.repository.ProfileScreenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileScreenViewModel @Inject constructor(private val repository: ProfileScreenRepository) :
    ViewModel() {

    val userData: StateFlow<UserALLData?>
        get() = repository.userData

    init {
        viewModelScope.launch {
            repository.getUserDetails()
        }
    }


}