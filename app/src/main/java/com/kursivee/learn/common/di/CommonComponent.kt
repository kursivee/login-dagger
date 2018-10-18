package com.kursivee.learn.common.di

import dagger.Component
import com.kursivee.learn.activity.MainActivity
import com.kursivee.learn.activity.NextActivity
import com.kursivee.learn.common.api.di.ApiModule
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