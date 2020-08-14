package com.askominas.pastebinandroid.viewmodels

import androidx.lifecycle.MutableLiveData
import com.askominas.pastebinandroid.core.BaseViewModel
import com.askominas.pastebinandroid.repository.PastebinApiRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class CreatePasteViewModel(val pastebinApiRepository: PastebinApiRepository) : BaseViewModel() {

    val pasteText = MutableLiveData<String>()

    fun onCreatePaste() {
        backgroundScope.launch {
            val result = runCatching { pastebinApiRepository.postPaste(pasteText = pasteText.value) }
            result.onSuccess { rawPaste ->
                Timber.d("Retrieved raw paste: $rawPaste")
            }.onFailure { exception ->
                Timber.d("Failed to retrieve raw paste ${exception.message}")
            }
        }
    }
}
