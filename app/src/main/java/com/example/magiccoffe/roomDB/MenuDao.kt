package com.example.magiccoffe.roomDB

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MenuDao {
    @Query("SELECT * FROM Menu")
    fun getAll(): Flow<List<Menu>>
    @Upsert
    suspend fun upsertAll(menu: Menu)
    @Delete
    suspend fun delete(menu: Menu)

}