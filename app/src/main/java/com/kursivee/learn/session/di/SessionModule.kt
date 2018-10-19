package com.kursivee.learn.session.di

import com.kursivee.learn.session.SessionService
import com.kursivee.learn.session.UserData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SessionModule {
    // Not sure how to handle data classes other than this way
    // Using SessionScoped and inject constructor bitches about on the class
    // Multiple constructors
    @Provides
    @SessionScoped
    fun getUserData() : UserData {
        return UserData()
    }
}