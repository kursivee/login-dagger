package com.kursivee.learn.base

import android.support.v7.app.AppCompatActivity
import com.kursivee.learn.App
import com.kursivee.learn.di.ApplicationComponent
import com.kursivee.learn.session.di.SessionComponent

open class BaseSessionActivity : AppCompatActivity() {

    fun getApplicationComponent() : ApplicationComponent {
        return (application as App).applicationComponent
    }

    fun getSessionComponent() : SessionComponent {
        return (application as App).sessionComponent
    }
}