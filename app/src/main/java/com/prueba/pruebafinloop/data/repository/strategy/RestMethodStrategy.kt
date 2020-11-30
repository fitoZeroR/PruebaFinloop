package com.prueba.pruebafinloop.data.repository.strategy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.prueba.pruebafinloop.presentation.framework.network.api.Resource
import kotlinx.coroutines.Dispatchers

fun <T, A> resultLiveDataRest(networkCall: suspend () -> Resource<A>,
                              returnData: suspend (A) -> LiveData<T>): LiveData<Resource<T>> =
    liveData(Dispatchers.IO) {
        emit(Resource.loading())

        val responseStatus = networkCall.invoke()
        if (responseStatus.status == Resource.Status.SUCCESS) {
            val source = returnData.invoke(responseStatus.data!!).map {
                Resource.success(
                    it
                )
            }
            emitSource(source)
        } else if (responseStatus.status == Resource.Status.ERROR) {
            emit(Resource.error(responseStatus.message!!))
        }
    }

fun <T, A> returnLiveDataMapper(data: T, function: (T) -> A): LiveData<A> {
    val getDataLiveData: MutableLiveData<A> = MutableLiveData()
    getDataLiveData.postValue(function(data))
    return getDataLiveData
}