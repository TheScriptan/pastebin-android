package com.askominas.pastebinandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.askominas.pastebinandroid.R
import com.askominas.pastebinandroid.core.AuthenticationState
import com.askominas.pastebinandroid.core.BaseFragment
import com.askominas.pastebinandroid.databinding.FragmentListPasteBinding
import com.askominas.pastebinandroid.viewmodels.ListPasteViewModel
import org.koin.java.KoinJavaComponent

class ListPasteFragment :
    BaseFragment<ListPasteViewModel, FragmentListPasteBinding>(ListPasteViewModel::class) {
    override val layoutResourceID: Int
        get() = R.layout.fragment_list_paste

    private val authenticationState: AuthenticationState by KoinJavaComponent.inject(
        AuthenticationState::class.java
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        binding.userLoggedIn = authenticationState.isLoggedIn

        return view
    }
}
