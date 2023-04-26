package com.glitchypuma.hypermarketsifter

data class ItemState(
    val items: List<Item> = emptyList(),
    val name: String = "",
    val price: Int = 0,
    val type: String = "",
    val isAddingItem: Boolean = false,
    val sortType: SortType = SortType.TYPE
)
