package com.askominas.pastebinandroid.koin

import com.askominas.pastebinandroid.core.AppPreferences
import com.askominas.pastebinandroid.core.AuthenticationState
import com.askominas.pastebinandroid.repository.PastebinApiRepository
import com.askominas.pastebinandroid.repository.PastebinApiRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val singleModules = module {
    single { AppPreferences(androidContext()) }
    single { AuthenticationState() }
    single<PastebinApiRepository> { PastebinApiRepositoryImpl(pastebinApi = get()) }
}
