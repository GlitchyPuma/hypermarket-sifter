package com.glitchypuma.hypermarketsifter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ItemViewModel(
    private val dao: ItemDao
): ViewModel() {

    private val _sortType = MutableStateFlow(SortType.TYPE)
    //if new sort type is selected, flow will update allowing for reactivity
    private val _items = _sortType
        .flatMapLatest { sortType ->
            when(sortType) {
                SortType.NAME -> dao.getItemsOrderedByName()
                SortType.PRICE -> dao.getItemsOrderedByPrice()
                SortType.TYPE -> dao.getItemsOrderedByType()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(ItemState())
    //combine three input flows into one flow: state
    val state = combine(_state, _sortType, _items) { state, sortType, items ->
        state.copy(
            items = items,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ItemState())

    fun onEvent(event: ItemEvent) {
        when(event){
            is ItemEvent.DeleteItem -> {
                viewModelScope.launch {
                    dao.deleteItem(event.item
                ) }
            }
            ItemEvent.HideDialog -> {
                _state.update { it.copy(
                    isAddingItem = false
                ) }
            }
            is ItemEvent.SetName -> {
                _state.update { it.copy(
                    name = event.name
                ) }
            }
            is ItemEvent.SetPrice -> {
                _state.update { it.copy(
                    price = event.price
                ) }
            }
            is ItemEvent.SetType -> {
                _state.update { it.copy(
                    type = event.type
                ) }
            }
            ItemEvent.ShowDialog -> {
                _state.update { it.copy(
                    isAddingItem = true
                ) }
            }
            is ItemEvent.SortItems -> {
                _sortType.value = event.sortType
            }
            ItemEvent.SaveItem -> {
                val name = state.value.name
                val price = state.value.price
                val type = state.value.type

                if(name.isBlank() || type.isBlank()){
                    return
                }

                val item = Item(
                    name = name,
                    price = price,
                    type = type
                )
                viewModelScope.launch {
                    dao.upsertItem(item)
                }
                _state.update { it.copy(
                    isAddingItem = false,
                    name = "",
                    price = 0,
                    type = ""
                ) }
            }

        }
    }

}