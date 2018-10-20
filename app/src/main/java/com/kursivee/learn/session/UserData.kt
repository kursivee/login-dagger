package com.kursivee.learn.session

import com.kursivee.learn.session.di.SessionScoped
import javax.inject.Inject

// Thinking about just removing data class all together
// Not sure of a scenario where this would be useful

@SessionScoped
class UserData @Inject constructor() {
    lateinit var name: String
    lateinit var token: String

    fun clear() {
        name = ""
        token = ""
    }
}