package com.example.tmdbmovieapp.repository

import androidx.lifecycle.LiveData
import com.example.tmdbmovieapp.data.Result
import com.example.tmdbmovieapp.data.TmdbService
import com.example.tmdbmovieapp.data.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val database: AppDatabase) {

    val films: LiveData<List<Result>> = database.movieDao.getMovies()

    suspend fun refresh() {
        withContext(Dispatchers.IO) {
            val movies = TmdbService.buildService().getMovies("a86cd96f8b111284d749bd3d94ca9ca7")
            database.movieDao.insertAll(movies.results)
        }
    }
}