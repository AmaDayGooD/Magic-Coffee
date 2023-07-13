package com.example.magiccoffe.roomDB

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MenuDao {
    @Query("SELECT * FROM Menu")
    fun getAll(): Flow<List<Menu>>
    @Query("SELECT * FROM Establishment")
    fun getAllEst(): Flow<List<Establishment>>
    @Query("SELECT * FROM Users")
    fun getAllUsers(): Flow<List<Users>>
    @Insert
    suspend fun setUser(users:Users)

    @Upsert
    suspend fun upsertAll(menu: Menu)
    @Delete
    suspend fun delete(menu: Menu)
}
