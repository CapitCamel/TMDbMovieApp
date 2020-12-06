package com.example.tmdbmovieapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.data.TmdbService
import com.example.tmdbmovieapp.databinding.FragmentPopularFilmsBinding
import kotlinx.android.synthetic.main.fragment_popular_films.*
import kotlinx.coroutines.launch

class PopularFilmsFragment : Fragment() {

    private val viewModel: PopularFilmsViewModel by lazy {
        ViewModelProvider(this).get(PopularFilmsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPopularFilmsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = PopularMoviesAdapter()
        return binding.root
    }

}