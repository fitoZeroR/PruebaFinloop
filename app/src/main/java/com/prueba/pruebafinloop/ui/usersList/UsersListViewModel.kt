package com.prueba.pruebafinloop.ui.usersList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.prueba.pruebafinloop.data.repository.UsersListRepository
import javax.inject.Inject

class UsersListViewModel @Inject constructor(private val usersListRepository: UsersListRepository) : ViewModel() {
    private val _requestGetUsersListLiveData: MutableLiveData<Unit> = MutableLiveData()
    val requestGetUsersListLiveData = _requestGetUsersListLiveData.switchMap { usersListRepository.getUsers() }

    fun getUsersList() {
        _requestGetUsersListLiveData.value = Unit
    }
}