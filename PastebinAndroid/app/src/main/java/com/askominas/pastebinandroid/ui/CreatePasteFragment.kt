package com.askominas.pastebinandroid.ui

import com.askominas.pastebinandroid.R
import com.askominas.pastebinandroid.core.base.BaseFragment
import com.askominas.pastebinandroid.databinding.FragmentCreatePasteBinding
import com.askominas.pastebinandroid.viewmodels.CreatePasteViewModel

class CreatePasteFragment :
    BaseFragment<CreatePasteViewModel, FragmentCreatePasteBinding>(CreatePasteViewModel::class) {

    override val layoutResourceID: Int
        get() = R.layout.fragment_create_paste
}
