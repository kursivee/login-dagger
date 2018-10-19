package com.kursivee.learn

import android.app.Application
import com.kursivee.learn.di.ApplicationComponent
import com.kursivee.learn.di.DaggerApplicationComponent
import com.kursivee.learn.session.di.SessionComponent

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent
    private var sessionComponent: SessionComponent? = null

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.create()
    }

    fun plusSessionComponent() : SessionComponent {
        // Yes I know this is NOT the kotfu way of nulls
        // Will update in next commit...I have to cook dinner lol
        if(sessionComponent == null) {
            sessionComponent = applicationComponent.sessionBuilder().build()
        }
        return sessionComponent!!
    }

}