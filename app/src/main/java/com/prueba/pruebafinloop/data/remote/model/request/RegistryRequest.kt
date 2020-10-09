package com.prueba.pruebafinloop.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class RegistryRequest (
    @SerializedName("email")
    val email: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)