package com.askominas.pastebinandroid.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class BaseViewModel : ViewModel() {
    private val backgroundJob = Job()
    protected val backgroundScope = CoroutineScope(Dispatchers.IO + backgroundJob)
}
