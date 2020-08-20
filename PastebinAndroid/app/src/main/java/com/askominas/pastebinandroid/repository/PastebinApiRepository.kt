package com.askominas.pastebinandroid.repository

import com.askominas.pastebinandroid.api.PastebinApi
import com.askominas.pastebinandroid.core.NetworkManager
import com.askominas.pastebinandroid.database.PasteDao
import com.askominas.pastebinandroid.models.Paste
import com.askominas.pastebinandroid.models.PasteList
import com.google.gson.Gson
import fr.arnaudguyon.xmltojsonlib.XmlToJson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent.inject

interface PastebinApiRepository {
    suspend fun getRawPaste(pasteId: String): String
    suspend fun postPaste(pasteText: String?): String
    suspend fun authenticate(username: String?, password: String?): String
    suspend fun getPasteList(userKey: String, resultsLimit: Int): List<Paste>
}

class PastebinApiRepositoryImpl(val pastebinApi: PastebinApi, val pasteDao: PasteDao) : PastebinApiRepository {

    private val networkManager: NetworkManager by inject(NetworkManager::class.java)

    override suspend fun getRawPaste(pasteId: String): String = withContext(Dispatchers.IO) {
        val responseRawPaste = pastebinApi.getRawPaste(pasteId).execute()
        responseRawPaste.body() ?: "Empty Response: ${responseRawPaste.errorBody()?.string()}"
    }

    override suspend fun postPaste(pasteText: String?): String = withContext(Dispatchers.IO) {
        val responsePostPaste = pastebinApi.postPaste(pasteText = pasteText).execute()
        responsePostPaste.body() ?: "Empty Response: ${responsePostPaste.errorBody()?.string()}"
    }

    override suspend fun authenticate(username: String?, password: String?): String =
        withContext(Dispatchers.IO) {
            val responseUserKey = pastebinApi.authenticate(
                username = username,
                password = password
            ).execute()
            responseUserKey.body() ?: "unk"
        }

    override suspend fun getPasteList(userKey: String, resultsLimit: Int): List<Paste> =
        withContext(Dispatchers.IO) {
            if(networkManager.isOnline()) {
                val responsePasteList = pastebinApi.getPasteList(
                    userKey = userKey,
                    resultsLimit = resultsLimit
                ).execute()
                val json =
                    XmlToJson.Builder(responsePasteList.body() ?: "{}").build().toFormattedString()
                val pasteList: List<Paste> = Gson().fromJson(json, PasteList::class.java).pasteList
                pasteDao.insertAll(pasteList)
                pasteList
            } else {
                pasteDao.getList()
            }
        }
}
