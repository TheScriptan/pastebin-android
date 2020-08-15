package com.askominas.pastebinandroid.core

import android.content.Context
import android.content.SharedPreferences

const val NAME = "PastebinAndroid"
const val MODE = Context.MODE_PRIVATE

const val USER_KEY_FIELD = "user_key"
const val DEFAULT_USER_KEY = "unk"

class AppPreferences(val context: Context) {

    private var preferences: SharedPreferences = context.getSharedPreferences(NAME, MODE)

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var userKey: String
        get() = preferences.getString(USER_KEY_FIELD, DEFAULT_USER_KEY) ?: DEFAULT_USER_KEY
        set(value) = preferences.edit { it.putString(USER_KEY_FIELD, value) }
}
