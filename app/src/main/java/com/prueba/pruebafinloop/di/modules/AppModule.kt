package com.prueba.pruebafinloop.di.modules

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.prueba.pruebafinloop.MainApplication
import com.prueba.pruebafinloop.data.remote.api.IRetrofitService
import com.prueba.pruebafinloop.data.remote.api.RemoteDataSource
import dagger.Module
import javax.inject.Singleton
import dagger.Provides

@Module(includes = [RetrofitModule::class])
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: MainApplication) = application

    @Provides
    @Singleton
    fun providesSharedPreferences(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Singleton
    @Provides
    fun provideGetCampusRemoteDataSource(iRetrofitService: IRetrofitService)
            = RemoteDataSource(iRetrofitService)
}