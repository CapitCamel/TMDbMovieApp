package com.example.tmdbmovieapp.ui

import android.app.Application
import androidx.lifecycle.*
import com.example.tmdbmovieapp.data.PopularMovies
import com.example.tmdbmovieapp.data.Result
import com.example.tmdbmovieapp.data.TmdbService
import com.example.tmdbmovieapp.data.database.getDatabase
import com.example.tmdbmovieapp.repository.Repository
import kotlinx.coroutines.launch

class PopularFilmsViewModel(application: Application) : AndroidViewModel(application){
    private val _status = MutableLiveData<MovieApiStatus>()
    val status: LiveData<MovieApiStatus>
        get() = _status

    private val repository = Repository(getDatabase(application))

    val movies = repository.films

//    private val _movies = MutableLiveData<PopularMovies>()
//    val movies: LiveData<PopularMovies>
//        get()=_movies

    init {
        getPopularMovies()
    }

    private fun getPopularMovies(){
        viewModelScope.launch {
            _status.value = MovieApiStatus.LOADING
            try {
                //_movies.value = TmdbService.buildService().getMovies("a86cd96f8b111284d749bd3d94ca9ca7")
                repository.refresh()
                _status.value = MovieApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MovieApiStatus.ERROR
            }
        }
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(PopularFilmsViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return PopularFilmsViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

}

enum class MovieApiStatus { LOADING, ERROR, DONE }