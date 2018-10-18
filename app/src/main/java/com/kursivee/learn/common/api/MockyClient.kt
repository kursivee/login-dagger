package com.kursivee.learn.common.api

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

// We probably only want one instance of the MockyClient
// floating around in the Dagger2 ether. The only case where
// that probably wouldn't be the case is if your Retrofit
// baseUrl changes, but if that were the case, you'd
// need to have Retrofit not be @Singleton too. Since
// Retrofit is being provided as @Singleton, this can be too.
@Singleton
class MockyClient @Inject constructor(var retrofit: Retrofit) {

    fun getApi() : MockyApi {
        return retrofit
            .create(MockyApi::class.java)
    }
}