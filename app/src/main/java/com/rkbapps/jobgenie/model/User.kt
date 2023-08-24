package com.rkbapps.jobgenie.model

data class User(
    val id: Long? = null,
    val uid: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
)
