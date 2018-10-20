package com.kursivee.learn.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.kursivee.learn.App
import com.kursivee.learn.base.BaseSessionActivity
import com.kursivee.learn.home.HomeActivity
import com.kursivee.learn.login.R
import com.kursivee.learn.login.rest.LoginClient
import com.kursivee.learn.login.rest.LoginRequest
import com.kursivee.learn.session.SessionService
import com.kursivee.learn.session.di.SessionComponent
import com.kursivee.learn.session.di.SessionModule
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var loginClient: LoginClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).applicationComponent.inject(this)
        findViewById<Button>(R.id.submitBtn).setOnClickListener {
            onButtonClick()
        }
    }

    private fun onButtonClick() {
        val name = findViewById<TextView>(R.id.usernameTv).text.toString()
        val password = findViewById<TextView>(R.id.passwordTv).text.toString()
        login(name, password)
    }

    private fun login(name: String, password: String) {
        val loginRequest = LoginRequest(name, password)
        CoroutineScope(Dispatchers.IO).launch {
            val request = loginClient.api().login(loginRequest)
            val response = request.await()
            if(response.isSuccessful) {
                goToHome(name, response.body()?.sessionToken!!)
            }
        }
    }

    private fun goToHome(name: String, token: String) {
        val loginParcel = LoginParcel(name, token)
        HomeActivity.start(this, loginParcel)
    }
}
