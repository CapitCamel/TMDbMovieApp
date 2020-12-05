package com.example.tmdbmovieapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.data.TmdbService
import kotlinx.android.synthetic.main.fragment_popular_films.*
import kotlinx.coroutines.launch

class PopularFilmsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadData()
        return inflater.inflate(R.layout.fragment_popular_films, container, false)
    }

    private fun loadData() = viewLifecycleOwner.lifecycleScope.launch {
        val apiService = TmdbService.buildService()

        try {
            val movies = apiService.getMovies("a86cd96f8b111284d749bd3d94ca9ca7")
            recyclerView.adapter = PopularMoviesAdapter(movies = movies.results)


        } catch (e: Exception) {

        }

    }
}