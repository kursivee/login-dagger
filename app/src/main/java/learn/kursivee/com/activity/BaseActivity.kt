package learn.kursivee.com.activity

import android.support.v7.app.AppCompatActivity
import learn.kursivee.com.App
import learn.kursivee.com.common.di.CommonComponent

open class BaseActivity : AppCompatActivity() {

    private fun getApp() : App {
        return (application as App)
    }

    fun getCommonComponent() : CommonComponent {
        return getApp().commonComponent
    }
}