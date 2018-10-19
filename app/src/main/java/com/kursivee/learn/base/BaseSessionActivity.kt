package com.kursivee.learn.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kursivee.learn.App
import com.kursivee.learn.di.ApplicationComponent
import com.kursivee.learn.session.di.SessionComponent

open class BaseSessionActivity : AppCompatActivity() {

    lateinit var sessionComponent: SessionComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionComponent =  (application as App).plusSessionComponent()
    }
}