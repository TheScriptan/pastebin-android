package com.askominas.pastebinandroid.core.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.askominas.pastebinandroid.core.ViewHolderClickListeners
import com.askominas.pastebinandroid.core.extensions.onClick
import com.askominas.pastebinandroid.core.extensions.onLongClick

abstract class BaseViewHolder<T : Any>(
    itemView: View,
    private val clickListeners: ViewHolderClickListeners? = null
) : RecyclerView.ViewHolder(itemView) {

    open fun bind(value: T) {
        bindClickListeners()
    }

    private fun bindClickListeners() {
        clickListeners?.run {
            onItemClick?.let { onClick(it) }
            onItemLongClick?.let { onLongClick(it) }
        }
    }
}
