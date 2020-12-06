package com.example.tmdbmovieapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdbmovieapp.data.PopularMovies
import com.example.tmdbmovieapp.data.Result
import com.example.tmdbmovieapp.data.TmdbService
import kotlinx.coroutines.launch

class PopularFilmsViewModel : ViewModel(){
    private val _status = MutableLiveData<MovieApiStatus>()
    val status: LiveData<MovieApiStatus>
        get() = _status

    private val _movies = MutableLiveData<PopularMovies>()
    val movies: LiveData<PopularMovies>
        get()=_movies

    init {
        getPopularMovies()
    }

    private fun getPopularMovies(){
        viewModelScope.launch {
            _status.value = MovieApiStatus.LOADING
            try {
                _movies.value = TmdbService.buildService().getMovies("a86cd96f8b111284d749bd3d94ca9ca7")
                _status.value = MovieApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MovieApiStatus.ERROR
            }
        }
    }
}

enum class MovieApiStatus { LOADING, ERROR, DONE }