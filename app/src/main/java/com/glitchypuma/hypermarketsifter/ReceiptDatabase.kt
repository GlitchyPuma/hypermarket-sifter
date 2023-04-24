package com.glitchypuma.hypermarketsifter

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Item::class],
    version = 1
)
abstract class ReceiptDatabase: RoomDatabase() {
    abstract val dao: ItemDao
}