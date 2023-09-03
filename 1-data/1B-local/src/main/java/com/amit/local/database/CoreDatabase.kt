package com.amit.local.database

import com.amit.local.dao.JokeItemDao
import com.amit.local.entity.JokesEntity
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [JokesEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CoreDatabase : RoomDatabase() {
    abstract fun jokeDao(): JokeItemDao
}