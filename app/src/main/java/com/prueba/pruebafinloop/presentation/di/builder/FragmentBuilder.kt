package com.prueba.pruebafinloop.presentation.di.builder

import com.prueba.pruebafinloop.presentation.di.annotations.FragmentScoped
import com.prueba.pruebafinloop.presentation.ui.usersList.UsersListFragment
import com.prueba.pruebafinloop.presentation.ui.registry.RegistryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun provideRegistryFragmentFactory(): RegistryFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun provideListUsersFragmentFactory(): UsersListFragment
}