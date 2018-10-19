package com.kursivee.learn.login

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginParcel(val name: String, val token: String) : Parcelable {
}