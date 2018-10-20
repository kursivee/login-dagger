package com.kursivee.learn.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.kursivee.learn.session.di.SessionComponent
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module(subcomponents = [
    SessionComponent::class
])
class ApplicationModule {

    @ApplicationScoped
    @Provides
    fun getRetrofit() : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("http://192.168.0.9:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}