package com.amit.local.di

import androidx.room.Room
import com.amit.local.database.CoreDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module{

    single {
        Room.databaseBuilder(androidApplication(), CoreDatabase::class.java, "unlimit_amit")
            .fallbackToDestructiveMigration()
            .build()
    }

    factory { get<CoreDatabase>().jokeDao() }
}