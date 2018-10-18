package com.kursivee.learn

import android.app.Application
import com.kursivee.learn.common.di.CommonComponent
import com.kursivee.learn.common.di.DaggerCommonComponent

class App : Application() {
    lateinit var commonComponent: CommonComponent

    override fun onCreate() {
        super.onCreate()
        commonComponent = DaggerCommonComponent
            .create()
    }
}