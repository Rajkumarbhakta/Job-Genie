package com.rkbapps.jobgenie.model

data class User(
    var id: Int?,
    val uid: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
)
