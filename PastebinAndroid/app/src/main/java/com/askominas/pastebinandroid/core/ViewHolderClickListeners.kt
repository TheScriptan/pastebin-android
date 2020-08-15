package com.askominas.pastebinandroid.core

import com.askominas.pastebinandroid.core.extensions.ViewHolderClickType

interface ViewHolderClickListeners {
    val onItemClick: ViewHolderClickType?
    val onItemLongClick: ViewHolderClickType?
}
