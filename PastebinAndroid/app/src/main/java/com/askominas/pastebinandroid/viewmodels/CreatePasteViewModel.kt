package com.askominas.pastebinandroid.viewmodels

import com.askominas.pastebinandroid.core.BaseViewModel
import com.askominas.pastebinandroid.repository.PastebinApiRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class CreatePasteViewModel(val pastebinApiRepository: PastebinApiRepository) : BaseViewModel() {

    fun onTestClick() {
        backgroundScope.launch {
            val result = runCatching { pastebinApiRepository.getRawPaste("ahWqr3WNg") }
            result.onSuccess { rawPaste ->
                Timber.d("Retrieved raw paste: $rawPaste")
            }.onFailure { exception ->
                Timber.d("Failed to retrieve raw paste ${exception.message}")
            }
        }
    }
}
