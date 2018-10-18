package com.kursivee.learn.activity

import android.support.v7.app.AppCompatActivity
import com.kursivee.learn.App
import com.kursivee.learn.common.di.CommonComponent

open class BaseActivity : AppCompatActivity() {

    private fun getApp() : App {
        return (application as App)
    }

    fun getCommonComponent() : CommonComponent {
        return getApp().commonComponent
    }
}