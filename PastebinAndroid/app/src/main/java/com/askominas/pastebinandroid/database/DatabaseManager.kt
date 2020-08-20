package com.askominas.pastebinandroid.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.askominas.pastebinandroid.models.Paste

@Database(entities = [Paste::class], version = 1, exportSchema = false)
abstract class DatabaseManager : RoomDatabase() {
    abstract val pasteDao: PasteDao
}
