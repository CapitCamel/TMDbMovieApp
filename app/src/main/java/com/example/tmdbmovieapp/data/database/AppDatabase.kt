package com.example.tmdbmovieapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tmdbmovieapp.data.Result

@Database(entities = [Result::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract val movieDao: MovieDao
}

private lateinit var INSTANCE: AppDatabase

fun getDatabase(context: Context): AppDatabase {
    synchronized(AppDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java,
                "movies").build()
        }
    }
    return INSTANCE
}