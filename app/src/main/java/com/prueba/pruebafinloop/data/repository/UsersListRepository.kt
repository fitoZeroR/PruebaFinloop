package com.prueba.pruebafinloop.data.repository

import com.prueba.pruebafinloop.data.remote.api.RemoteDataSource
import com.prueba.pruebafinloop.data.repository.strategy.resultLiveDataRest
import com.prueba.pruebafinloop.data.repository.strategy.returnLiveDataMapper
import com.prueba.pruebafinloop.domain.model.User
import okhttp3.internal.toImmutableList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersListRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {
    fun getUsers() =
        resultLiveDataRest(
            networkCall = { remoteDataSource.fetchDataGetUser() },
            returnData = { userInfoResponse ->
                returnLiveDataMapper(userInfoResponse) {
                    val userList: MutableList<User> = mutableListOf()
                    for (index in it.userInfo.indices) {
                        userList.add(User(it.userInfo[index].email, it.userInfo[index].username))
                    }
                    userList.toImmutableList()
                }
            })
}