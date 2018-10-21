package com.kursivee.learn.common.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kursivee.learn.App
import com.kursivee.learn.common.dialog.DialogService
import com.kursivee.learn.common.net.MoshiService
import com.kursivee.learn.di.ApplicationComponent
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {
    @Inject
    lateinit var dialogService: DialogService

    @Inject
    lateinit var moshiService: MoshiService

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        applicationComponent = (application as App).applicationComponent
    }
}