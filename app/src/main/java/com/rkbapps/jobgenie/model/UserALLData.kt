package com.rkbapps.jobgenie.model

data class UserALLData(
    val educations: List<Any>,
    val experiences: List<Any>,
    val message: String,
    val skills: List<Any>,
    val status: String,
    val user: User
)