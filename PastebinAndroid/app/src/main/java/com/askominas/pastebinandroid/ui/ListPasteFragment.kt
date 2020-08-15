package com.askominas.pastebinandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.askominas.pastebinandroid.R
import com.askominas.pastebinandroid.core.AuthenticationState
import com.askominas.pastebinandroid.core.base.BaseFragment
import com.askominas.pastebinandroid.databinding.FragmentListPasteBinding
import com.askominas.pastebinandroid.models.Paste
import com.askominas.pastebinandroid.models.PasteList
import com.askominas.pastebinandroid.utils.event.EventObserver
import com.askominas.pastebinandroid.viewmodels.ListPasteViewModel
import org.koin.java.KoinJavaComponent.inject

class ListPasteFragment :
    BaseFragment<ListPasteViewModel, FragmentListPasteBinding>(ListPasteViewModel::class) {
    override val layoutResourceID: Int
        get() = R.layout.fragment_list_paste

    private val authenticationState: AuthenticationState by inject(AuthenticationState::class.java)
    private lateinit var listPasteLayoutManager: LinearLayoutManager
    private lateinit var listPasteAdapter: ListPasteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        binding.userLoggedIn = authenticationState.isLoggedIn

        listPasteLayoutManager = LinearLayoutManager(context)
        listPasteAdapter = ListPasteAdapter(
            onClickCallback = {
                // Implement onClick callback
            },
            deletePasteCallback = {
                // Implement deletePasteCallback
            })
        binding.recyclerListPaste.apply {
            adapter = listPasteAdapter
            layoutManager = listPasteLayoutManager
        }
        viewModel.receivedPasteListEvent.observe(viewLifecycleOwner, receivedPasteListObserver)
        authenticationState.isLoggedInLiveData.observe(viewLifecycleOwner, EventObserver {
            binding.userLoggedIn = authenticationState.isLoggedIn
            binding.executePendingBindings()
        })
        return view
    }

    private val receivedPasteListObserver = EventObserver<List<Paste>> { pasteList ->
        listPasteAdapter.updatePasteList(pasteList)
    }
}
