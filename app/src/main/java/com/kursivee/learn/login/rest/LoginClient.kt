package com.kursivee.learn.login.rest

import com.kursivee.learn.di.ApplicationScoped
import retrofit2.Retrofit
import javax.inject.Inject

@ApplicationScoped
class LoginClient @Inject constructor(var retrofit: Retrofit) {

    fun api() : LoginApi {
        return retrofit.create(LoginApi::class.java)
    }
}