package com.prueba.pruebafinloop

import android.app.Application
import com.prueba.pruebafinloop.presentation.di.component.AppComponent
import com.prueba.pruebafinloop.presentation.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainApplication: Application(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()

        val component: AppComponent by lazy {
            DaggerAppComponent
                .builder()
                .application(this)
                .build()
        }

        component.inject(this)
    }
}