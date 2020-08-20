package com.askominas.pastebinandroid.database

import androidx.room.Database
import com.askominas.pastebinandroid.models.Paste

@Database(entities = [Paste::class], version = 1, exportSchema = false)
abstract class DatabaseManager() {
    abstract val pasteDao: PasteDao
}
