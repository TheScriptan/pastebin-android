package com.askominas.pastebinandroid.ui.viewholders

import android.view.View
import android.widget.TextView
import com.askominas.pastebinandroid.R
import com.askominas.pastebinandroid.core.BaseViewHolder
import com.askominas.pastebinandroid.core.ViewHolderClickListeners
import com.askominas.pastebinandroid.models.Paste

class ListPasteViewHolder(
    itemView: View,
    clickListeners: ViewHolderClickListeners
) : BaseViewHolder<Paste>(itemView, clickListeners) {

    private val pasteItemTitle: TextView = itemView.findViewById(R.id.text_paste_item_title)
    private val pasteItemHits: TextView = itemView.findViewById(R.id.text_paste_item_hits)
    private val pasteItemFormat: TextView = itemView.findViewById(R.id.text_paste_item_format)

    override fun bind(value: Paste) {
        pasteItemTitle.text =
            if (value.pasteTitle.isEmpty()) itemView.context.getString(R.string.paste_item_no_title)
            else value.pasteTitle
        pasteItemHits.text = value.pasteHits.toString()
        pasteItemFormat.text = value.pasteFormatShort
        super.bind(value)
    }
}
