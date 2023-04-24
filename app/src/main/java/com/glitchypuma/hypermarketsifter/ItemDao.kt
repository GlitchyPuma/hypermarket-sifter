package com.glitchypuma.hypermarketsifter

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Upsert
    suspend fun upsertItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)

    @Query("SELECT * FROM item ORDER BY name ASC")
    fun getItemsOrderedByName(): Flow<List<Item>>

    @Query("SELECT * FROM item ORDER BY price ASC")
    fun getItemsOrderedByPrice(): Flow<List<Item>>

    @Query("SELECT * FROM item ORDER BY type ASC")
    fun getItemsOrderedByType(): Flow<List<Item>>

}