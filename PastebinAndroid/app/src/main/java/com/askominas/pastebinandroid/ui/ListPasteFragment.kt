package com.askominas.pastebinandroid.ui

import com.askominas.pastebinandroid.R
import com.askominas.pastebinandroid.core.BaseFragment
import com.askominas.pastebinandroid.databinding.FragmentListPasteBinding
import com.askominas.pastebinandroid.viewmodels.ListPasteViewModel

class ListPasteFragment :
    BaseFragment<ListPasteViewModel, FragmentListPasteBinding>(ListPasteViewModel::class) {
    override val layoutResourceID: Int
        get() = R.layout.fragment_list_paste
}
