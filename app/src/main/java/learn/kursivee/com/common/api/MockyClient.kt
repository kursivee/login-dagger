package learn.kursivee.com.common.api

import retrofit2.Retrofit

class MockyClient(var retrofit: Retrofit) {

    fun getApi() : MockyApi {
        return retrofit
            .create(MockyApi::class.java)
    }
}