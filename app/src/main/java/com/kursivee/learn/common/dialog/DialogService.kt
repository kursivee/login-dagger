package com.kursivee.learn.common.dialog

import android.util.Log
import com.kursivee.learn.di.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class DialogService @Inject constructor(){
    fun showError(msg: String) {
        Log.d("ERROR", msg)
    }
}