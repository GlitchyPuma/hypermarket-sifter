package com.glitchypuma.hypermarketsifter

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    val name: String,
    val price: Int,
    val type: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
