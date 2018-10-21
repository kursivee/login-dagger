package com.kursivee.learn.common.session.di

import com.kursivee.learn.secured.home.HomeActivity
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