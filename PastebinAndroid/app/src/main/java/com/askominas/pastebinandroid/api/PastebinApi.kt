package com.askominas.pastebinandroid.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PastebinApi {
    @GET("raw/{pasteId}")
    fun getRawPaste(@Path("pasteId") pasteId: String): Call<String>
}
