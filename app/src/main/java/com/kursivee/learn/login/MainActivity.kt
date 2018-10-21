package com.kursivee.learn.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.kursivee.learn.App
import com.kursivee.learn.common.dialog.DialogService
import com.kursivee.learn.home.HomeActivity
import com.kursivee.learn.login.service.LoginService
import com.kursivee.learn.net.GenericNetworkError
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var loginService: LoginService

    @Inject
    lateinit var dialogService: DialogService

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
        val response = loginService.login(name, password)
        if(response.isSuccessful) {
            goToHome(name, response.body()?.sessionToken!!)
        } else {
            displayError(response.errorBody()?.string())
        }
    }


    // I don't like this... need to figure out how to properly handle errors
    // Pretty sure I can inject Moshi...but where? and is it a singleton?
    private fun displayError(message: String?) {
        val moshi = Moshi.Builder().build()
        val error: JsonAdapter<GenericNetworkError> = moshi.adapter(GenericNetworkError::class.java)
        val generic: GenericNetworkError? = error.fromJson(message)
        dialogService.showError(generic.toString())

    }

    private fun goToHome(name: String, token: String) {
        val loginParcel = LoginParcel(name, token)
        HomeActivity.start(this, loginParcel)
    }
}
