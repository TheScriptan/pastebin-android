package com.askominas.pastebinandroid.koin

import com.askominas.pastebinandroid.viewmodels.CreatePasteViewModel
import com.askominas.pastebinandroid.viewmodels.ListPasteViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel {
        CreatePasteViewModel(
            pastebinApiRepository = get()
        )
    }
    viewModel {
        ListPasteViewModel()
    }
}
