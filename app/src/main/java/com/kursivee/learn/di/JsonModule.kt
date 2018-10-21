package com.kursivee.learn.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides

@Module
class JsonModule {

    @ApplicationScoped
    @Provides
    fun getMoshi() : Moshi {
        return Moshi.Builder().build()
    }
}