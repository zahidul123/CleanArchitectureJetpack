package com.example.composecleanarchitecture.db.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.composecleanarchitecture.db.room.entity.QuestionCategory

@Dao
interface QuestionCategoryDao {

    @Query("SELECT * FROM QuestionCategory")
    abstract fun getAll(): List<QuestionCategory>

    @Query("SELECT * FROM QuestionCategory where localId=:localId")
    abstract fun getAllById(localId: Int): List<QuestionCategory>

    @Insert
    abstract fun insert(categories: List<QuestionCategory>): List<Long>

    @Insert
    abstract fun insert(users: QuestionCategory)

    @Query("DELETE FROM QuestionCategory")
    abstract fun delete(): Int

    @Delete
    abstract fun delete(categories: List<QuestionCategory>): Int

    @Delete
    abstract fun delete(category: QuestionCategory): Int
}