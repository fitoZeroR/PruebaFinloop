package com.prueba.pruebafinloop.presentation.di.component

import android.app.Application
import com.prueba.pruebafinloop.MainApplication
import com.prueba.pruebafinloop.presentation.di.builder.ActivityBuilder
import com.prueba.pruebafinloop.presentation.di.modules.AppModule
import com.prueba.pruebafinloop.presentation.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilder::class,
        AppModule::class,
        ViewModelModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    fun inject(app: MainApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}