package com.askominas.pastebinandroid.utils

import android.view.View
import androidx.databinding.BindingAdapter

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("android:visibility")
    fun setVisibility(view: View, value: Boolean?) {
        view.visibility = (if (value == true) View.VISIBLE else View.GONE)
    }
}
