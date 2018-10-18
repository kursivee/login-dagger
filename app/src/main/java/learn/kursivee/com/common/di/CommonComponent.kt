package learn.kursivee.com.common.di

import dagger.Component
import learn.kursivee.com.activity.MainActivity
import learn.kursivee.com.activity.NextActivity
import learn.kursivee.com.common.api.di.ApiModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    CommonModule::class,
    ApiModule::class
])
interface CommonComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: NextActivity)
}