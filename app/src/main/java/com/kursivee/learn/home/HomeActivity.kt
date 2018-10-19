package com.kursivee.learn.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.TextView
import com.kursivee.learn.base.BaseSessionActivity
import com.kursivee.learn.login.LoginParcel
import com.kursivee.learn.login.R
import com.kursivee.learn.session.SessionService
import javax.inject.Inject

class HomeActivity : BaseSessionActivity() {

    @Inject
    lateinit var sessionService: SessionService

    companion object {
        fun start(context: Context, parcel: Parcelable? = null) {
            val intent = Intent(context, HomeActivity::class.java)
            parcel?.let {
                intent.putExtra("parcel", it)
            }
            context.startActivity(intent)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        sessionComponent.inject(this)
        intent.extras.getParcelable<LoginParcel>("parcel")?.let {
            sessionService.userData.name = it.name
            sessionService.userData.token = it.token
        }
        findViewById<TextView>(R.id.user).text = sessionService.userData.name
        findViewById<TextView>(R.id.token).text = sessionService.userData.token
    }
}
