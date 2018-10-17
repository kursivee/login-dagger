package learn.kursivee.com.common.di

import dagger.Component
import learn.kursivee.com.login.activity.MainActivity
import learn.kursivee.com.login.activity.NextActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [
    CommonModule::class
])
interface CommonComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: NextActivity)
}