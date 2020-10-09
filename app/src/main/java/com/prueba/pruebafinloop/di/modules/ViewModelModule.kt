package com.prueba.pruebafinloop.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prueba.pruebafinloop.di.annotations.ViewModelKey
import com.prueba.pruebafinloop.ui.registry.RegistryViewModel
import com.prueba.pruebafinloop.ui.usersList.UsersListViewModel
import com.prueba.pruebafinloop.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RegistryViewModel::class)
    internal abstract fun bindRegistryViewModel(mainViewModel: RegistryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UsersListViewModel::class)
    internal abstract fun bindUsersListViewModel(loginViewModel: UsersListViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}