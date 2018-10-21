package com.kursivee.learn.common.net

import com.kursivee.learn.di.ApplicationScoped
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import javax.inject.Inject

@ApplicationScoped
class MoshiService @Inject constructor(var moshi: Moshi) {
    fun <T> adapter(clazz: Class<T>) : JsonAdapter<T> {
        return moshi.adapter<T>(clazz)
    }
}