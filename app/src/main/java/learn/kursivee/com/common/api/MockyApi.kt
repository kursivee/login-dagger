package learn.kursivee.com.common.api

import kotlinx.coroutines.experimental.Deferred
import learn.kursivee.com.common.api.response.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface MockyApi {
    @GET("5bc7d8e9320000350059fc34")
    fun get() : Deferred<Response<UserResponse>>
}