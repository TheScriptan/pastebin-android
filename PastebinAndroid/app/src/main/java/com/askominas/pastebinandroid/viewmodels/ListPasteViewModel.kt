package com.askominas.pastebinandroid.viewmodels

import androidx.lifecycle.MutableLiveData
import com.askominas.pastebinandroid.core.AppPreferences
import com.askominas.pastebinandroid.core.AuthenticationState
import com.askominas.pastebinandroid.core.BaseViewModel
import com.askominas.pastebinandroid.models.PasteList
import com.askominas.pastebinandroid.repository.PastebinApiRepository
import com.askominas.pastebinandroid.utils.event.Event
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import timber.log.Timber

class ListPasteViewModel(val pastebinApiRepository: PastebinApiRepository) : BaseViewModel() {

    private val authenticationState: AuthenticationState by inject(AuthenticationState::class.java)
    private val preferences: AppPreferences by inject(AppPreferences::class.java)

    val receivedPasteListEvent = MutableLiveData<Event<PasteList>>()

    init {
        if (authenticationState.isLoggedIn) {
            backgroundScope.launch {
                val userKey = preferences.userKey
                val resultPasteList = runCatching {
                    pastebinApiRepository.getPasteList(userKey, 10)
                }
                resultPasteList.onSuccess {
                    receivedPasteListEvent.postValue(Event(it))
                    Timber.d("Retrieved user paste list:\n${it.pasteList[0].pasteTitle}")
                }.onFailure { error ->
                    Timber.d("Failed to retrieve user paste list: ${error.message}")
                }
            }
        }
    }
}
