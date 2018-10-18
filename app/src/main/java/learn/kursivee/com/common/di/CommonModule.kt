package learn.kursivee.com.common.di

import dagger.Module
import dagger.Provides
import learn.kursivee.com.common.api.MockyClient
import learn.kursivee.com.common.services.DependencyService
import learn.kursivee.com.common.services.UserDataService
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