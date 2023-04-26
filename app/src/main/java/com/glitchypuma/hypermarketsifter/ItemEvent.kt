package com.glitchypuma.hypermarketsifter

sealed interface ItemEvent {
    object SaveItem : ItemEvent
    data class SetName(val name: String) : ItemEvent
    data class SetPrice(val price: Int) : ItemEvent
    data class SetType(val type: String) : ItemEvent
    object ShowDialog: ItemEvent
    object HideDialog: ItemEvent
    data class SortItems(val sortType: SortType) : ItemEvent
    data class DeleteItem(val item: Item): ItemEvent
}