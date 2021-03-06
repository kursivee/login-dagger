package com.kursivee.learn.di

import com.kursivee.learn.common.session.di.SessionComponent
import dagger.Module

@Module(subcomponents = [
    SessionComponent::class
])
class ApplicationModule {
}