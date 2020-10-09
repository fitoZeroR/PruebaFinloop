package com.prueba.pruebafinloop.data.remote.api

import com.prueba.pruebafinloop.data.remote.model.request.LoginRequest
import com.prueba.pruebafinloop.data.remote.model.request.RegistryRequest
import com.prueba.pruebafinloop.data.remote.model.response.SuccessResponse
import com.prueba.pruebafinloop.data.remote.model.response.UserInfoResponse
import com.prueba.pruebafinloop.utils.Constants
import retrofit2.Response
import retrofit2.http.*

interface IRetrofitService {
    @POST(Constants.Apis.ENDPOINT_lOGIN)
    suspend fun postLogin(@Body loginRequest: LoginRequest): Response<SuccessResponse>

    @POST(Constants.Apis.ENDPOINT_USERS)
    suspend fun postUser(@Body registryRequest: RegistryRequest): Response<SuccessResponse>

    @GET(Constants.Apis.ENDPOINT_USERS)
    suspend fun getUsers(): Response<UserInfoResponse>
}