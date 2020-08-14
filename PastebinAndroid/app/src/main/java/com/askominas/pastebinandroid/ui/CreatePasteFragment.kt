package com.askominas.pastebinandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.askominas.pastebinandroid.R
import com.askominas.pastebinandroid.databinding.FragmentCreatePasteBinding
import com.askominas.pastebinandroid.viewmodels.CreatePasteViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class CreatePasteFragment : Fragment() {

    lateinit var binding: FragmentCreatePasteBinding
    private val viewModel: CreatePasteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_create_paste, container, false
            )
        val view = binding.root

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return view
    }
}
