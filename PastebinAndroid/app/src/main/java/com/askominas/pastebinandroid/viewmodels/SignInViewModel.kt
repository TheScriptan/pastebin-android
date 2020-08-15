package com.askominas.pastebinandroid.viewmodels

import androidx.lifecycle.MutableLiveData
import com.askominas.pastebinandroid.api.API_ERROR_INVALID_LOGIN
import com.askominas.pastebinandroid.api.API_ERROR_INVALID_POST
import com.askominas.pastebinandroid.core.BaseViewModel
import com.askominas.pastebinandroid.repository.PastebinApiRepository
import com.askominas.pastebinandroid.utils.event.Event
import kotlinx.coroutines.launch

class SignInViewModel(val pastebinApiRepository: PastebinApiRepository) : BaseViewModel() {
    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val signInEvent = MutableLiveData<Event<String>>()

    fun onSignInClick() {
        backgroundScope.launch {
            val resultUserKey = kotlin.runCatching {
                pastebinApiRepository.authenticate(
                    username = username.value,
                    password = password.value
                )
            }

            resultUserKey.onSuccess { userKey ->
                if (userKey == API_ERROR_INVALID_LOGIN || userKey == API_ERROR_INVALID_POST) {
                    signInEvent.postValue(Event("Invalid credentials"))
                    return@launch
                }
                signInEvent.postValue(Event("Login successful: $userKey"))
                // Store key locally
                // Navigate to Create Paste Screen
            }.onFailure {
                signInEvent.postValue(Event("Invalid credentials: ${it.message}"))
            }
        }
    }
}
