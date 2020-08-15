package com.askominas.pastebinandroid.viewmodels

import androidx.lifecycle.MutableLiveData
import com.askominas.pastebinandroid.core.base.BaseViewModel
import com.askominas.pastebinandroid.repository.PastebinApiRepository
import com.askominas.pastebinandroid.utils.event.Event
import kotlinx.coroutines.launch
import timber.log.Timber

class DisplayPasteViewModel(val pastebinApiRepository: PastebinApiRepository) : BaseViewModel() {

    val pasteContentEvent = MutableLiveData<Event<String>>()
    val pasteContent = MutableLiveData<String>()

    fun loadPasteContent(pasteKey: String) {
        backgroundScope.launch {
            val responsePasteContent = runCatching {
                pastebinApiRepository.getRawPaste(pasteKey)
            }
            responsePasteContent.onSuccess { pasteContent ->
                pasteContentEvent.postValue(Event(pasteContent))
            }.onFailure {
                Timber.d("Failed to load raw paste content")
            }
        }
    }
}
