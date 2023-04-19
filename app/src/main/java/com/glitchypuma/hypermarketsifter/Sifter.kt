package com.glitchypuma.hypermarketsifter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Sifter : AppCompatActivity() {

    var listItemModels : ArrayList<ListItemModel> = ArrayList<ListItemModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sifter)
        setUpListItemModels()
    }

    fun setUpListItemModels() {
        val receiptItems : Array<String> = resources.getStringArray(R.array.receipt_items_1)
        val receiptPrices : Array<String> = resources.getStringArray(R.array.receipt_prices_1)
        val receiptTypes : Array<String> = resources.getStringArray(R.array.receipt_types_1)

        for(i in 1..receiptItems.size ){
            listItemModels.add(ListItemModel(receiptItems[i], receiptPrices[i], receiptTypes[i]))
        }
    }
}