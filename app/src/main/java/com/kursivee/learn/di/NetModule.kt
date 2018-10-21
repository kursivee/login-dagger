package com.kursivee.learn.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetModule {

    @ApplicationScoped
    @Provides
    fun getRetrofit() : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("http://192.168.0.9:8080/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}