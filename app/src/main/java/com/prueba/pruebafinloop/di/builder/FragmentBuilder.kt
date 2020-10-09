package com.prueba.pruebafinloop.di.builder

import com.prueba.pruebafinloop.di.annotations.FragmentScoped
import com.prueba.pruebafinloop.ui.usersList.UsersListFragment
import com.prueba.pruebafinloop.ui.registry.RegistryFragment
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