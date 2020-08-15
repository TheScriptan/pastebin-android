package com.askominas.pastebinandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.askominas.pastebinandroid.R
import com.askominas.pastebinandroid.core.BaseFragment
import com.askominas.pastebinandroid.databinding.FragmentSignInBinding
import com.askominas.pastebinandroid.utils.event.EventObserver
import com.askominas.pastebinandroid.viewmodels.SignInViewModel

class SignInFragment :
    BaseFragment<SignInViewModel, FragmentSignInBinding>(SignInViewModel::class) {
    override val layoutResourceID: Int
        get() = R.layout.fragment_sign_in

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        viewModel.signInEvent.observe(viewLifecycleOwner, EventObserver {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            activity?.invalidateOptionsMenu()
        })

        return view
    }
}
