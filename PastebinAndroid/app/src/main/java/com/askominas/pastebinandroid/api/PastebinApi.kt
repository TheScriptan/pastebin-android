package com.askominas.pastebinandroid.api

import retrofit2.Call
import retrofit2.http.*

interface PastebinApi {
    @GET(RAW_PASTE_ENDPOINT)
    fun getRawPaste(@Path("pasteId") pasteId: String): Call<String>

    @FormUrlEncoded
    @POST(POST_PASTE_ENDPOINT)
    fun postPaste(
        @Field(API_DEV_KEY_FIELD) apiDevKey: String = API_DEV_KEY,
        @Field(API_OPTION_FIELD) apiOption: String = API_OPTION_FIELD_PASTE,
        @Field(API_PASTE_CODE_FIELD) pasteText: String?
    ): Call<String>
}