package com.example.tmdbmovieapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.data.Result
import com.example.tmdbmovieapp.databinding.FilmItemBinding

class PopularMoviesAdapter: ListAdapter<Result, MoviesViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(FilmItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.bind(marsProperty)
    }
}

class MoviesViewHolder(private val binding: FilmItemBinding):
        RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Result) {
        binding.film = movie
        binding.executePendingBindings()
    }
}