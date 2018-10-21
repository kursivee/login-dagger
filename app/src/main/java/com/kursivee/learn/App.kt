package com.kursivee.learn

import android.app.Application
import com.kursivee.learn.di.ApplicationComponent
import com.kursivee.learn.di.DaggerApplicationComponent
import com.kursivee.learn.common.session.di.SessionComponent

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent
    private var sessionComponent: SessionComponent? = null

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.create()
    }

    fun plusSessionComponent() : SessionComponent {
        // I think this is how you do it ??
        return this.sessionComponent
            ?: applicationComponent.sessionBuilder().build()
    }

    fun clearSessionComponent() {
        sessionComponent = null
    }

}