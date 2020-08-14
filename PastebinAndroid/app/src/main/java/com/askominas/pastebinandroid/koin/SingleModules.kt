package com.askominas.pastebinandroid.koin

import com.askominas.pastebinandroid.repository.TestRepository
import com.askominas.pastebinandroid.repository.TestRepositoryImpl
import org.koin.dsl.module

val singleModules = module {
    single<TestRepository> { TestRepositoryImpl() }
}
