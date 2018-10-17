package learn.kursivee.com.common

import android.support.v7.app.AppCompatActivity
import learn.kursivee.com.app.App
import learn.kursivee.com.common.di.CommonComponent

open class BaseActivity : AppCompatActivity() {

    fun getApp() : App {
        return (application as App)
    }

    fun getCommonComponent() : CommonComponent {
        return getApp().commonComponent
    }
}