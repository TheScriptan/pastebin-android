package com.askominas.pastebinandroid.viewmodels

import androidx.lifecycle.MutableLiveData
import com.askominas.pastebinandroid.api.API_ERROR_INVALID_LOGIN
import com.askominas.pastebinandroid.api.API_ERROR_INVALID_POST
import com.askominas.pastebinandroid.core.AppPreferences
import com.askominas.pastebinandroid.core.NetworkManager
import com.askominas.pastebinandroid.core.base.BaseViewModel
import com.askominas.pastebinandroid.repository.PastebinApiRepository
import com.askominas.pastebinandroid.ui.SignInFragmentDirections
import com.askominas.pastebinandroid.utils.event.Event
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject

class SignInViewModel(val pastebinApiRepository: PastebinApiRepository) : BaseViewModel() {

    private val preferences: AppPreferences by inject(AppPreferences::class.java)
    private val networkManager: NetworkManager by inject(NetworkManager::class.java)

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val signInEvent = MutableLiveData<Event<String>>()

    fun onSignInClick() {
        if (!networkManager.isOnline()) {
            signInEvent.postValue(Event("Network connection error. Please try again"))
            return
        }

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
                preferences.userKey = userKey
                navigateTo.postValue(Event(SignInFragmentDirections.actionSignInFragmentToCreatePasteFragment()))
            }.onFailure {
                signInEvent.postValue(Event("Invalid credentials: ${it.message}"))
            }
        }
    }
}
