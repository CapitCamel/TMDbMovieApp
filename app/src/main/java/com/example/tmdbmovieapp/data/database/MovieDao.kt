package com.example.tmdbmovieapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbmovieapp.data.Result

@Dao
interface MovieDao {
    @Query("select * from result")
    fun getMovies(): LiveData<List<Result>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( videos: List<Result>)
}