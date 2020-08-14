package com.askominas.pastebinandroid.ui

import com.askominas.pastebinandroid.R
import com.askominas.pastebinandroid.core.BaseFragment
import com.askominas.pastebinandroid.databinding.FragmentSignInBinding
import com.askominas.pastebinandroid.viewmodels.SignInViewModel

class SignInFragment :
    BaseFragment<SignInViewModel, FragmentSignInBinding>(SignInViewModel::class) {
    override val layoutResourceID: Int
        get() = R.layout.fragment_sign_in
}
