package com.prueba.pruebafinloop.data.remote.api

import com.prueba.pruebafinloop.data.remote.model.request.LoginRequest
import com.prueba.pruebafinloop.data.remote.model.request.RegistryRequest
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val iRetrofitService: IRetrofitService) : BaseDataSource() {

    suspend fun fetchDataPostLogin(loginRequest: LoginRequest) = getResult { iRetrofitService.postLogin(loginRequest) }

    suspend fun fetchDataPostUser(registryRequest: RegistryRequest) = getResult { iRetrofitService.postUser(registryRequest) }

    suspend fun fetchDataGetUser() = getResult { iRetrofitService.getUsers() }
}