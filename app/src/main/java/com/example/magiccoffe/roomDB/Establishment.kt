package com.example.magiccoffe.roomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Establishment(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name_Cafe") val nameCafe: String?,
    @ColumnInfo(name = "address_Cafe") val addressCafe: String?,
    @ColumnInfo(name = "image_Cafe") val imageCafe: String?,
    @ColumnInfo(name = "latitude_Cafe") val latitudeCafe: String?,
    @ColumnInfo(name = "longitude_Cafe") val longitudeCafe: String?
)

