package com.glitchypuma.hypermarketsifter

class ListItemModel(val itemName: String, val itemPrice: String, val itemType: String) {
    fun getItemName() : String {
        return itemName
    }
    fun getItemPrice() : String {
        return itemPrice
    }
    fun getItemType() : String {
        return itemType
    }

}