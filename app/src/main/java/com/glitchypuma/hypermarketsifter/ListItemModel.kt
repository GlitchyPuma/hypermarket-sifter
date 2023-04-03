package com.glitchypuma.hypermarketsifter

class ListItemModel(val itemName: String, val itemPrice: Float, val itemType: String) {
    fun getItemName() : String {
        return itemName
    }
    fun getItemPrice() : Float {
        return itemPrice
    }
    fun getItemType() : String {
        return itemType
    }

}