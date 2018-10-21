package com.kursivee.learn.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.kursivee.learn.App
import com.kursivee.learn.common.activity.BaseActivity
import com.kursivee.learn.common.dialog.DialogService
import com.kursivee.learn.secured.home.HomeActivity
import com.kursivee.learn.common.net.GenericNetworkError
import com.kursivee.learn.common.net.MoshiService
import com.kursivee.learn.login.rest.LoginClient
import java.net.ConnectException
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var loginClient: LoginClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        applicationComponent.inject(this)
        dialogService.context = this
        findViewById<Button>(R.id.submitBtn).setOnClickListener {
            onButtonClick()
        }
    }

    private fun onButtonClick() {
        val name = findViewById<TextView>(R.id.usernameTv).text.toString()
        val password = findViewById<TextView>(R.id.passwordTv).text.toString()
        try {
            val response = loginClient.login(name, password)
            if(response.isSuccessful) {
                goToHome(name, response.body()?.sessionToken!!)
            } else {
                displayError(response.errorBody()?.string())
            }
        } catch (e: ConnectException) {
            dialogService
                .errorAlert("Connection error", "Failed to connect to service")
                .show()
        }
    }

    // Need to clean up the way error are displayed. I don't like it.
    // I'm thinking maybe dialog service gets moshi service injected and has a way
    // To grab the messages and display?
    private fun displayError(message: String?) {
        val adapter = moshiService.adapter(GenericNetworkError::class.java)
        val error: GenericNetworkError? = adapter.fromJson(message)
        val alert = dialogService.errorAlert("Login error", error?.message.toString())
        // POC for action after close
        alert.setOnDismissListener {
            Log.d("main", "I'm closed")
        }
        alert.show()
    }

    private fun goToHome(name: String, token: String) {
        val loginParcel = LoginParcel(name, token)
        HomeActivity.start(this, loginParcel)
    }
}
