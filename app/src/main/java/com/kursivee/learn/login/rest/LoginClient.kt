package com.kursivee.learn.login.rest

import com.kursivee.learn.di.ApplicationScoped
import dagger.Provides
import kotlinx.coroutines.experimental.runBlocking
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

@ApplicationScoped
class LoginClient @Inject constructor(var loginApi: LoginApi) {

    fun login(username: String, password: String): Response<LoginResponse> = runBlocking {
        val loginRequest = LoginRequest(username, password)
        val response = loginApi.login(loginRequest).await()
        // POC for modifying response
        if (response.isSuccessful) {
            response.body()?.let {
                it.sessionToken += "heey"
            }
        }
        response
    }
}