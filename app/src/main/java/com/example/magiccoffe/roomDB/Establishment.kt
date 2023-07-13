package com.example.magiccoffe.roomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*@Entity
data class Establishment(
    @PrimaryKey(autoGenerate = true) val uid: Int? = 0,
    @ColumnInfo(name = "name_Cafe") val nameCafe: String?,
    @ColumnInfo(name = "address_Cafe") val addressCafe: String?,
    @ColumnInfo(name = "image_Cafe") val imageCafe: String?,
    @ColumnInfo(name = "latitude_Cafe") val latitudeCafe: String?,
    @ColumnInfo(name = "longitude_Cafe") val longitudeCafe: String?
)*/

@Entity(tableName = "Establishment")
data class Establishment (
    @PrimaryKey(autoGenerate = true) val cafe_id: Int? = 0,
    @ColumnInfo(name = "nameCafe") val nameCafe: String?,
    @ColumnInfo(name = "addressCafe") val addressCafe: String?,
    @ColumnInfo(name = "latitudeCafe") val latitude: Double?,
    @ColumnInfo(name = "longitudeCafe") val longitude: Double?,
)