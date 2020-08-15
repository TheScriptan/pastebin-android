package com.askominas.pastebinandroid.models

import com.google.gson.annotations.SerializedName

data class PasteList(
    @SerializedName("paste") val paste: List<Paste>
)
