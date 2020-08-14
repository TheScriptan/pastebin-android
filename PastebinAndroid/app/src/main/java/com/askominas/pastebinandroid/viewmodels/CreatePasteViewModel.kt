package com.askominas.pastebinandroid.viewmodels

import androidx.lifecycle.ViewModel
import com.askominas.pastebinandroid.repository.TestRepository
import timber.log.Timber

class CreatePasteViewModel(val testRepository: TestRepository) : ViewModel() {

    fun onTestClick() {
        val s = testRepository.helloTestRepository()
        Timber.d("onTestClick: $s")
    }
}
