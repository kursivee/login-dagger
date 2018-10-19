package com.kursivee.learn.home

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.kursivee.learn.App
import com.kursivee.learn.base.BaseSessionActivity
import com.kursivee.learn.login.R
import com.kursivee.learn.session.SessionService
import javax.inject.Inject

class HomeActivity : BaseSessionActivity() {

    @Inject
    lateinit var sessionService: SessionService

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        (application as App).sessionComponent.inject(this)
        findViewById<TextView>(R.id.user).text = sessionService.userData.name
        findViewById<TextView>(R.id.token).text = sessionService.userData.token
    }
}
