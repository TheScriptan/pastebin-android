package com.askominas.pastebinandroid.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.askominas.pastebinandroid.utils.event.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class BaseViewModel : ViewModel() {
    private val backgroundJob = Job()
    protected val backgroundScope = CoroutineScope(Dispatchers.IO + backgroundJob)

    val navigateTo = MutableLiveData<Event<NavDirections>>()
}
