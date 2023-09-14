package com.example.composecleanarchitecture.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composecleanarchitecture.db.room.dao.QuestionCategoryDao
import com.example.composecleanarchitecture.db.room.entity.QuestionCategory

@Database(entities = [QuestionCategory::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {
    abstract fun questionCategoryDao(): QuestionCategoryDao
}