package com.kursivee.learn.login.rest

import kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("login")
    fun login(@Body loginRequest: LoginRequest) : Deferred<Response<LoginResponse>>
}