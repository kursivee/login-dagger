package learn.kursivee.com.app.di

import dagger.Component
import learn.kursivee.com.login.activity.MainActivity
import learn.kursivee.com.login.activity.NextActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class
])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: NextActivity)
}