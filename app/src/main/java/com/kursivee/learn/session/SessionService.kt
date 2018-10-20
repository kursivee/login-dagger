package com.kursivee.learn.session

import com.kursivee.learn.session.di.SessionScoped
import javax.inject.Inject

@SessionScoped
data class SessionService @Inject constructor(var userData: UserData) {
    fun start(name: String, token: String) {
        userData.name = name
        userData.token = token
    }

    fun end() {
        userData.clear()
    }
}