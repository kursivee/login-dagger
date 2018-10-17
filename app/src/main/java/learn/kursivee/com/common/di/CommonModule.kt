package learn.kursivee.com.common.di

import dagger.Module
import dagger.Provides
import learn.kursivee.com.common.services.UserDataService
import javax.inject.Singleton

@Module
class CommonModule {

    @Provides
    @Singleton
    fun getUserDataService() : UserDataService {
        return UserDataService()
    }
}