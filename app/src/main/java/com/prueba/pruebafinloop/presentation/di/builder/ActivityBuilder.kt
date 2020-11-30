package com.prueba.pruebafinloop.presentation.di.builder

import com.prueba.pruebafinloop.presentation.di.annotations.PerActivity
import com.prueba.pruebafinloop.presentation.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBuilder {
    @PerActivity
    @ContributesAndroidInjector(modules = [FragmentBuilder::class])
    internal abstract fun bindMainActivity(): MainActivity
}