package com.amit.local.dao

import com.amit.local.entity.JokesEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface JokeItemDao {

    @Query("DELETE FROM Jokes_Table")
    suspend fun deleteAll(): Int

    @Query("SELECT * FROM Jokes_Table ORDER BY id DESC")
    suspend fun getAll(): List<JokesEntity>

    @Query("DELETE FROM Jokes_Table WHERE id = :jokeId")
    suspend fun deleteItem(jokeId: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: JokesEntity): Long

}