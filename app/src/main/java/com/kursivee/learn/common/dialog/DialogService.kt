package com.kursivee.learn.common.dialog

import android.app.AlertDialog
import android.content.Context
import android.os.Build
import android.provider.Settings
import android.util.Log
import android.view.WindowManager
import com.kursivee.learn.di.ApplicationScoped
import javax.inject.Inject

// Not scoped since it needs to be per activity
class DialogService @Inject constructor(){
    // Not sure if this is the best way to handle context?
    lateinit var context: Context

    fun errorAlert(title: String, msg: String) : AlertDialog {
        return AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(msg)
            .create()
    }
}