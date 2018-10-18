package learn.kursivee.com.common.services

import kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("5bc7d8e9320000350059fc34")
    fun get() : Deferred<Response<UserResponse>>
}