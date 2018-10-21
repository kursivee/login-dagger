package com.kursivee.learn.login.service

import com.kursivee.learn.di.ApplicationScoped
import com.kursivee.learn.login.rest.LoginClient
import com.kursivee.learn.login.rest.LoginRequest
import com.kursivee.learn.login.rest.LoginResponse
import com.kursivee.learn.net.GenericNetworkError
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import retrofit2.Response
import javax.inject.Inject

@ApplicationScoped
class LoginService @Inject constructor(var loginClient: LoginClient) {
     fun login(username: String, password: String) : Response<LoginResponse> = runBlocking {
        val loginRequest = LoginRequest(username, password)
        val response = loginClient.api().login(loginRequest).await()
        if(response.isSuccessful) {
            response.body()?.let {
                it.sessionToken += "heey"
            }
        }
        response
    }
}