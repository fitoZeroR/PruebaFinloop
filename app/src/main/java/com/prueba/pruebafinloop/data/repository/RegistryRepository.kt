package com.prueba.pruebafinloop.data.repository

import android.content.SharedPreferences
import com.prueba.pruebafinloop.presentation.framework.network.api.RemoteDataSource
import com.prueba.pruebafinloop.data.remote.model.request.LoginRequest
import com.prueba.pruebafinloop.data.remote.model.request.RegistryRequest
import com.prueba.pruebafinloop.data.repository.strategy.resultLiveDataRest
import com.prueba.pruebafinloop.data.repository.strategy.returnLiveDataMapper
import com.prueba.pruebafinloop.domain.model.Credential
import com.prueba.pruebafinloop.presentation.utils.Constants
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RegistryRepository
@Inject
constructor(
    private val sharedPreferences: SharedPreferences,
    private val remoteDataSource: RemoteDataSource
) {
    fun registryUser(registryRequest: RegistryRequest) =
        resultLiveDataRest(
            networkCall = { remoteDataSource.fetchDataPostUser(registryRequest) },
            returnData = { successResponse ->
                sharedPreferences.edit().apply {
                    putString(Constants.Preferences.ID, successResponse.id)
                    putString(Constants.Preferences.JWT, successResponse.jwt)
                    apply()
                }
                returnLiveDataMapper(successResponse) {
                    Credential(it.id, it.jwt)
                }
            }
        )

    fun login(loginRequest: LoginRequest) =
        resultLiveDataRest(
            networkCall = { remoteDataSource.fetchDataPostLogin(loginRequest) },
            returnData = { successResponse ->
                returnLiveDataMapper(successResponse) {
                    Credential(it.id, it.jwt)
                }
            }
        )

    fun registryValidate() =
        !(sharedPreferences.getString("id", "").equals("") and sharedPreferences.getString(
            "jwt",
            ""
        ).equals(""))
}