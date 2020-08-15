package com.askominas.pastebinandroid.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import com.askominas.pastebinandroid.utils.event.EventObserver
import org.koin.android.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

abstract class BaseFragment<VM : BaseViewModel, Binding : ViewDataBinding>(clazz: KClass<VM>) :
    Fragment() {

    abstract val layoutResourceID: Int
    protected lateinit var binding: Binding
    open val viewModel: VM by viewModel(clazz)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResourceID, container, false)
        val view = binding.root
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.viewModel, viewModel)

        viewModel.navigateTo.observe(viewLifecycleOwner, navigateToObserver)
        return view
    }

    private val navigateToObserver = EventObserver<NavDirections> { direction ->
        NavHostFragment.findNavController(this).navigate(direction)
    }
}
