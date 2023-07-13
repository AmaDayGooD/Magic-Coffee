package com.example.magiccoffe.roomDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class Users(
    @PrimaryKey val user_id: Int? = 0,
    @ColumnInfo(name = "nameUser") val nameUser: String?,
    @ColumnInfo(name = "passwordUser") val passwordUser: String?,
    @ColumnInfo(name = "numberPhoneUser") val numberPhoneUser: String?,
    @ColumnInfo(name = "emailUser") val emailUser: String?,

)
