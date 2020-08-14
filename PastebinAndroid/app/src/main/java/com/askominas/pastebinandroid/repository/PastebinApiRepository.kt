package com.askominas.pastebinandroid.repository

import com.askominas.pastebinandroid.api.PastebinApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface PastebinApiRepository {
    suspend fun getRawPaste(pasteId: String): String
    suspend fun postPaste(pasteText: String?): String
}

class PastebinApiRepositoryImpl(val pastebinApi: PastebinApi) : PastebinApiRepository {
    override suspend fun getRawPaste(pasteId: String): String = withContext(Dispatchers.IO) {
        val responseRawPaste = pastebinApi.getRawPaste(pasteId).execute()
        responseRawPaste.body() ?: "Empty Response: ${responseRawPaste.errorBody()?.string()}"
    }

    override suspend fun postPaste(pasteText: String?): String = withContext(Dispatchers.IO) {
        val responsePostPaste = pastebinApi.postPaste(pasteText = pasteText).execute()
        responsePostPaste.body() ?: "Empty Response: ${responsePostPaste.errorBody()?.string()}"
    }
}
