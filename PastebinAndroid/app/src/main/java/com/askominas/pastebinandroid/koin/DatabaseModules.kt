package com.askominas.pastebinandroid.koin

import android.app.Application
import androidx.room.Room
import com.askominas.pastebinandroid.database.DATABASE_NAME
import com.askominas.pastebinandroid.database.DatabaseManager
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun createDatabase(application: Application): DatabaseManager =
        Room.databaseBuilder(application, DatabaseManager::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    fun createPasteDao(database: DatabaseManager) = database.pasteDao

    single { createDatabase(androidApplication()) }
    single { createPasteDao(database = get()) }
}
