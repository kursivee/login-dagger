package com.kursivee.learn.di

import com.kursivee.learn.session.di.SessionComponent
import dagger.Component

@Component(modules = [
    ApplicationModule::class
])
interface ApplicationComponent {
    fun sessionBuilder() : SessionComponent.Builder
}