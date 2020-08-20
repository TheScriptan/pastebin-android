package com.askominas.pastebinandroid.ui.viewholders

import com.askominas.pastebinandroid.core.extensions.ViewHolderClickType

interface ViewHolderClickListeners {
    val onItemClick: ViewHolderClickType?
    val onItemLongClick: ViewHolderClickType?
}
