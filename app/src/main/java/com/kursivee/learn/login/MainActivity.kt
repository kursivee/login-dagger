package com.kursivee.learn.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kursivee.learn.App
import com.kursivee.learn.base.BaseSessionActivity
import com.kursivee.learn.home.HomeActivity
import com.kursivee.learn.login.R
import com.kursivee.learn.session.SessionService
import com.kursivee.learn.session.di.SessionComponent
import com.kursivee.learn.session.di.SessionModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginParcel = LoginParcel("user", "token")
        HomeActivity.start(this, loginParcel)
    }
}
