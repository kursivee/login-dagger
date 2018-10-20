package com.kursivee.learn.session

import com.kursivee.learn.session.di.SessionScoped
import javax.inject.Inject

@SessionScoped
class UserData @Inject constructor() {
    lateinit var name: String
    lateinit var token: String
}