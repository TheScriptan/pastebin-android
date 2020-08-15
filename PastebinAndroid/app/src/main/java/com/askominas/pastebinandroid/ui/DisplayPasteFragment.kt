package com.askominas.pastebinandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.askominas.pastebinandroid.R
import com.askominas.pastebinandroid.core.base.BaseFragment
import com.askominas.pastebinandroid.databinding.FragmentDisplayPasteBinding
import com.askominas.pastebinandroid.utils.event.EventObserver
import com.askominas.pastebinandroid.viewmodels.DisplayPasteViewModel

class DisplayPasteFragment :
    BaseFragment<DisplayPasteViewModel, FragmentDisplayPasteBinding>(DisplayPasteViewModel::class) {
    override val layoutResourceID: Int
        get() = R.layout.fragment_display_paste

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        arguments?.apply {
            val pasteKey = getString("pasteKey") ?: ""
            viewModel.loadPasteContent(pasteKey)
        }

        viewModel.pasteContentEvent.observe(viewLifecycleOwner, EventObserver { pasteContent ->
            binding.textDisplayPasteContent.text = pasteContent
        })

        return view
    }
}
