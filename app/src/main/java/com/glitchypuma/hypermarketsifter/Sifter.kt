package com.glitchypuma.hypermarketsifter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Sifter : AppCompatActivity() {

    var listItemModels : ArrayList<ListItemModel> = ArrayList<ListItemModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sifter)
    }

    fun setUpListItemModels() {

    }
}