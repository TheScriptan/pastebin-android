package com.askominas.pastebinandroid.ui.viewholders

import android.view.View
import android.widget.TextView
import com.askominas.pastebinandroid.R
import com.askominas.pastebinandroid.core.base.BaseViewHolder
import com.askominas.pastebinandroid.models.Paste

class ListPasteViewHolder(
    itemView: View,
    clickListeners: ViewHolderClickListeners
) : BaseViewHolder<Paste>(itemView, clickListeners) {

    private val pasteItemTitle: TextView = itemView.findViewById(R.id.text_paste_item_title)
    private val pasteItemHits: TextView = itemView.findViewById(R.id.text_paste_item_hits)
    private val pasteItemFormat: TextView = itemView.findViewById(R.id.text_paste_item_format)

    override fun bind(value: Paste) {
        pasteItemTitle.text = if (value.title.isEmpty()) {
            value.title = itemView.context.getString(R.string.paste_item_no_title)
            value.title
        } else {
            value.title
        }
        pasteItemHits.text = value.clicks.toString()
        pasteItemFormat.text = value.formatShort
        super.bind(value)
    }
}
