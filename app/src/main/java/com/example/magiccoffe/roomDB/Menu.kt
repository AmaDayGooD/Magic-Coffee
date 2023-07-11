package com.example.magiccoffe.roomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Menu(
    @ColumnInfo(name = "name_Cofe") val nameCofe: String,
    @ColumnInfo(name = "cost_Cofe") val costCofe: Double,
    @ColumnInfo(name = "image_Cofe") val imageCofe: String,
    @PrimaryKey(autoGenerate = true) val uid: Int? = 0,
)
