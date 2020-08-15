package com.askominas.pastebinandroid.core

import org.koin.java.KoinJavaComponent.inject

class AuthenticationState {

    private val preferences: AppPreferences by inject(AppPreferences::class.java)

    val isLoggedIn: Boolean
        get() = preferences.userKey != DEFAULT_USER_KEY
}
