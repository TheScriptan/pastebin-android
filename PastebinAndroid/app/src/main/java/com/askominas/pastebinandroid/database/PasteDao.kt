package com.askominas.pastebinandroid.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.askominas.pastebinandroid.models.Paste

interface PasteDao {

    @Query("SELECT * FROM $PASTE_TABLE_NAME")
    fun getList(): List<Paste>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(paste: Paste)

    @Delete
    fun delete(paste: Paste)
}
