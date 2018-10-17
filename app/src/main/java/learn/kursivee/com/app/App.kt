package learn.kursivee.com.app

import android.app.Application
import learn.kursivee.com.app.di.ApplicationComponent
import learn.kursivee.com.app.di.ApplicationModule
import learn.kursivee.com.app.di.DaggerApplicationComponent
import learn.kursivee.com.common.di.CommonComponent
import learn.kursivee.com.common.di.CommonModule
import learn.kursivee.com.common.di.DaggerCommonComponent

class App : Application() {
    lateinit var applicationComponent : ApplicationComponent
    lateinit var commonComponent: CommonComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        commonComponent = DaggerCommonComponent
            .create()
    }
}