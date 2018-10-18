package learn.kursivee.com.common.di

import dagger.Module
import dagger.Provides
import learn.kursivee.com.common.services.ApiClient
import learn.kursivee.com.common.services.DependencyService
import learn.kursivee.com.common.services.UserDataService
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
    fun getApiClient() : ApiClient {
        return ApiClient()
    }
}