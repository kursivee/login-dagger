package com.kursivee.learn

import android.app.Application
import com.kursivee.learn.di.ApplicationComponent
import com.kursivee.learn.di.DaggerApplicationComponent
import com.kursivee.learn.session.di.SessionComponent

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent
    lateinit var sessionComponent: SessionComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.create()
        sessionComponent = applicationComponent.sessionBuilder().build()
    }
}