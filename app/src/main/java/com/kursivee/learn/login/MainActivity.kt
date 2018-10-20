package com.kursivee.learn.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
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
        findViewById<Button>(R.id.submitBtn).setOnClickListener {
            onButtonClick()
        }
    }

    private fun onButtonClick() {
        val name = findViewById<TextView>(R.id.usernameTv).text.toString()
        val token = findViewById<TextView>(R.id.passwordTv).text.toString()
        goToHome(name, token)
    }

    private fun goToHome(name: String, token: String) {
        val loginParcel = LoginParcel(name, token)
        HomeActivity.start(this, loginParcel)
    }
}
