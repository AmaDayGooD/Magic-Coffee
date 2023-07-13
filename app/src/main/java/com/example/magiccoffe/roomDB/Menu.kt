package com.example.magiccoffe.roomDB

import androidx.room.ColumnInfo
import androidx.room.Entity

import androidx.room.PrimaryKey

/*@Entity
data class Menu(
    @ColumnInfo(name = "name_Cofe") val nameCofe: String,
    @ColumnInfo(name = "cost_Cofe") val costCofe: Double,
    @ColumnInfo(name = "image_Cofe") val imageCofe: String,
    @PrimaryKey(autoGenerate = true) val uid: Int? = 0,
)*/

@Entity(tableName = "Menu")
data class Menu (
    @PrimaryKey
    @ColumnInfo(name = "menu_id")val menu_id: Int,
    @ColumnInfo(name = "cafe_id") val cafe_id: Int,
    @ColumnInfo(name = "coffee_name")val coffee_name: String,
    @ColumnInfo(name = "price") val price: Double,
    @ColumnInfo(name = "image_url") val image_url: String,
)
