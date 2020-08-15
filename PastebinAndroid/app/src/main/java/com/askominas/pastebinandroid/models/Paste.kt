package com.askominas.pastebinandroid.models

import com.google.gson.annotations.SerializedName

data class Paste(
    @SerializedName("content") val content: String,
    @SerializedName("paste_private") val pastePrivate: Int,
    @SerializedName("paste_title") val pasteTitle: String,
    @SerializedName("paste_format_short") val pasteFormatShort: String,
    @SerializedName("paste_hits") val pasteHits: Int,
    @SerializedName("paste_expire_date") val pasteExpireDate: Int,
    @SerializedName("paste_date") val pasteDate: Int,
    @SerializedName("paste_format_long") val pasteFormatLong: String,
    @SerializedName("paste_key") val pasteKey: String,
    @SerializedName("paste_size") val pasteSize: Int,
    @SerializedName("paste_url") val pasteUrl: String
)
