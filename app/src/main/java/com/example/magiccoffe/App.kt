package com.example.magiccoffe

import android.app.Application
import com.example.magiccoffe.roomDB.DataBase

class App : Application() {
    val dataBase by lazy { DataBase.createDataBase(this) }
}