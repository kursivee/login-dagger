package learn.kursivee.com

import android.app.Application
import learn.kursivee.com.common.di.CommonComponent
import learn.kursivee.com.common.di.DaggerCommonComponent

class App : Application() {
    lateinit var commonComponent: CommonComponent

    override fun onCreate() {
        super.onCreate()
        commonComponent = DaggerCommonComponent
            .create()
    }
}