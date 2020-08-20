package com.askominas.pastebinandroid.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.askominas.pastebinandroid.R
import com.askominas.pastebinandroid.ui.viewholders.ViewHolderClickListeners
import com.askominas.pastebinandroid.core.extensions.ViewHolderClickType
import com.askominas.pastebinandroid.models.Paste
import com.askominas.pastebinandroid.ui.viewholders.ListPasteViewHolder

class ListPasteAdapter(
    val onClickCallback: (paste: Paste) -> Unit,
    val deletePasteCallback: () -> Unit
) : RecyclerView.Adapter<ListPasteViewHolder>() {

    private var pasteList: List<Paste> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPasteViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_paste_item, parent, false)
        return ListPasteViewHolder(view, ListPasteAdapterClickListener())
    }

    override fun onBindViewHolder(holder: ListPasteViewHolder, position: Int) {
        holder.bind(pasteList[position])
    }

    override fun getItemCount(): Int = pasteList.size

    fun updatePasteList(newPasteList: List<Paste>) {
        pasteList = newPasteList
        notifyDataSetChanged()
    }

    inner class ListPasteAdapterClickListener :
        ViewHolderClickListeners {
        override val onItemClick: ViewHolderClickType? = { pos, type ->
            onClickCallback(pasteList[pos])
        }
        override val onItemLongClick: ViewHolderClickType? = { pos, type ->
            deletePasteCallback()
        }
    }
}
