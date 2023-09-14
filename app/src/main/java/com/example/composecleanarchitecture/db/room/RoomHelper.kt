package com.example.composecleanarchitecture.db.room

import android.content.Context
import androidx.room.Room

class RoomHelper(private val context: Context)  {

    private val db = Room.databaseBuilder(context, RoomDB::class.java, "DB").allowMainThreadQueries().build()


    fun getDatabase(): RoomDB {
        return db
    }
}