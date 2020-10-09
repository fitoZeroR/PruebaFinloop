package com.prueba.pruebafinloop.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class SuccessResponse (
    @SerializedName("id")
    val id: String,
    @SerializedName("jwt")
    val jwt: String,
)