package com.prueba.pruebafinloop.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class UserInfoResponse (
    @SerializedName("resources")
    val userInfo: List<UsersListResponse>,
    @SerializedName("count")
    val count: String
)