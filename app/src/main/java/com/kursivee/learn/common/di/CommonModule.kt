package com.kursivee.learn.common.di

import dagger.Module
import dagger.Provides
import com.kursivee.learn.common.api.MockyClient
import com.kursivee.learn.common.services.DependencyService
import com.kursivee.learn.common.services.UserDataService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class CommonModule {

    @Provides
    @Singleton
    fun getUserDataService(dependencyService: DependencyService) : UserDataService {
        return UserDataService(dependencyService)
    }

    @Provides
    @Singleton
    fun getDependencyService() : DependencyService {
        return DependencyService()
    }

    @Provides
    fun getApiClient(retrofit: Retrofit) : MockyClient {
        return MockyClient(retrofit)
    }
}