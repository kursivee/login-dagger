package com.kursivee.learn.common.api

import retrofit2.Retrofit

class MockyClient(var retrofit: Retrofit) {

    fun getApi() : MockyApi {
        return retrofit
            .create(MockyApi::class.java)
    }
}