package com.kursivee.learn.di

import com.kursivee.learn.login.MainActivity
import com.kursivee.learn.common.session.di.SessionComponent
import dagger.Component

@Component(modules = [
    ApplicationModule::class,
    NetModule::class,
    JsonModule::class
])
@ApplicationScoped
interface ApplicationComponent {
    fun inject(activity: MainActivity)
    fun sessionBuilder() : SessionComponent.Builder
}