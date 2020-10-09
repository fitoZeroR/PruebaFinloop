package com.prueba.pruebafinloop.di.builder

import com.prueba.pruebafinloop.di.annotations.PerActivity
import com.prueba.pruebafinloop.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityBuilder {
    @PerActivity
    @ContributesAndroidInjector(modules = [FragmentBuilder::class])
    internal abstract fun bindMainActivity(): MainActivity
}