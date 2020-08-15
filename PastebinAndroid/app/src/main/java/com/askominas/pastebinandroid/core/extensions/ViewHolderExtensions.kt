package com.askominas.pastebinandroid.core.extensions

import androidx.recyclerview.widget.RecyclerView

typealias ViewHolderClickType = (pos: Int, type: Int) -> Unit

fun <T : RecyclerView.ViewHolder> T.onClick(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(adapterPosition, itemViewType)
    }
    return this
}

fun <T : RecyclerView.ViewHolder> T.onLongClick(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnLongClickListener {
        event.invoke(adapterPosition, itemViewType)
        true
    }
    return this
}
