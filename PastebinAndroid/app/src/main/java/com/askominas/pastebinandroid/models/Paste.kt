package com.askominas.pastebinandroid.models

import androidx.room.Entity
import com.askominas.pastebinandroid.database.PASTE_TABLE_NAME
import com.google.gson.annotations.SerializedName

@Entity(tableName = PASTE_TABLE_NAME)
data class Paste(
    @SerializedName("content") val content: String,
    @SerializedName("paste_private") val pastePrivate: Int,
    @SerializedName("paste_title") var title: String,
    @SerializedName("paste_format_short") val formatShort: String,
    @SerializedName("paste_hits") val clicks: Int,
    @SerializedName("paste_expire_date") val expireDate: Int,
    @SerializedName("paste_date") val date: Int,
    @SerializedName("paste_format_long") val formatLong: String,
    @SerializedName("paste_key") val key: String,
    @SerializedName("paste_size") val size: Int,
    @SerializedName("paste_url") val url: String
)
