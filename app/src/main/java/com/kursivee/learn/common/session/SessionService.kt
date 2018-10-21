package com.kursivee.learn.common.session

import com.kursivee.learn.common.session.di.SessionScoped
import javax.inject.Inject

@SessionScoped
class SessionService @Inject constructor() {
    var userData: UserData = UserData()

    fun start(name: String, token: String) {
        userData.name = name
        userData.token = token
    }

    fun end() {
        userData.clear()
    }
}