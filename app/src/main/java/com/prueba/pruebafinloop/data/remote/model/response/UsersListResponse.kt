package com.prueba.pruebafinloop.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class UsersListResponse (
    @SerializedName("id")
    val id: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("username")
    val username: String,
)