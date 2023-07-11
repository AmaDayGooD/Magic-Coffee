package com.example.magiccoffe.roomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Menu::class], version = 1, exportSchema = false)
abstract class DataBase() : RoomDatabase(){
abstract val dao : MenuDao
    companion object{
        fun createDataBase(context : Context): DataBase{
            return Room.databaseBuilder(
                context,
                DataBase::class.java,
                "test.db"
            ).build()
        }
    }

}