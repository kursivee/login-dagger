package com.kursivee.learn.common.session

data class UserData  constructor(var name: String =  "", var token: String = "") {
    fun clear() {
        name = ""
        token = ""
    }
}