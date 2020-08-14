package com.askominas.pastebinandroid.koin

import com.askominas.pastebinandroid.repository.PastebinApiRepository
import com.askominas.pastebinandroid.repository.PastebinApiRepositoryImpl
import org.koin.dsl.module

val singleModules = module {
    single<PastebinApiRepository> { PastebinApiRepositoryImpl(pastebinApi = get()) }
}
