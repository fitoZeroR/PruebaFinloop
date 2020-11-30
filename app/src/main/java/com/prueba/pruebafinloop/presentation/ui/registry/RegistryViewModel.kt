package com.prueba.pruebafinloop.presentation.ui.registry

import androidx.lifecycle.*
import com.prueba.pruebafinloop.data.remote.model.request.LoginRequest
import com.prueba.pruebafinloop.data.remote.model.request.RegistryRequest
import com.prueba.pruebafinloop.data.repository.RegistryRepository
import javax.inject.Inject

class RegistryViewModel @Inject constructor(private val registryRepository: RegistryRepository) : ViewModel() {
    private val _requestRegistryLiveData: MutableLiveData<RegistryRequest> = MutableLiveData()
    val requestRegistryLiveData = _requestRegistryLiveData.switchMap { registryRepository.registryUser(it) }

    fun sendRegistry(registryRequest: RegistryRequest) {
        _requestRegistryLiveData.value = registryRequest
    }


    private val _requestLoginLiveData: MutableLiveData<LoginRequest> = MutableLiveData()
    val requestLoginLiveData = _requestLoginLiveData.switchMap { registryRepository.login(it) }

    fun sendLogin(loginRequest: LoginRequest) {
        _requestLoginLiveData.value = loginRequest
    }

    fun registryValidate() = registryRepository.registryValidate()
}