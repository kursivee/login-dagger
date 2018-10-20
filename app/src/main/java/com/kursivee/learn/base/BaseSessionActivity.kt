package com.kursivee.learn.base

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kursivee.learn.App
import com.kursivee.learn.di.ApplicationComponent
import com.kursivee.learn.login.MainActivity
import com.kursivee.learn.session.di.SessionComponent

open class BaseSessionActivity : AppCompatActivity() {

    lateinit var sessionComponent: SessionComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionComponent =  (application as App).plusSessionComponent()
    }

    // Putting this here temporarily. I'm thinking once I implement bottom navigation it'll
    // go somewhere there.
    fun logout() {
        (application as App).clearSessionComponent()
        startActivity(Intent(this, MainActivity::class.java))
    }
}