package com.kursivee.learn.session.di

import com.kursivee.learn.home.HomeActivity
import com.kursivee.learn.login.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [
    SessionModule::class
])
@SessionScoped
interface SessionComponent {
    fun inject(activity: HomeActivity)

    @Subcomponent.Builder
    interface Builder {
        fun sessionModule(sessionModule: SessionModule)
        fun build() : SessionComponent
    }
}