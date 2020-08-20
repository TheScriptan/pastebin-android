package com.askominas.pastebinandroid.database

import androidx.room.*
import com.askominas.pastebinandroid.models.Paste

@Dao
interface PasteDao {

    @Query("SELECT * FROM $PASTE_TABLE_NAME")
    suspend fun getList(): List<Paste>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(paste: Paste)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pasteList: List<Paste>)

    @Delete
    fun delete(paste: Paste)
}
