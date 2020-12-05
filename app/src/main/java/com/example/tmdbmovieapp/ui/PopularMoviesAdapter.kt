package com.example.tmdbmovieapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.data.Result

class PopularMoviesAdapter(val movies: List<Result>): RecyclerView.Adapter<MoviesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_item, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        return holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}
class MoviesViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
    private val photo: ImageView = itemView.findViewById(R.id.movie_photo)
    private val title: TextView = itemView.findViewById(R.id.movie_title)

    fun bind(movie: Result) = with(itemView) {
        Glide.with(itemView.context).load("https://image.tmdb.org/t/p/w500${movie.poster_path}").into(photo)
        title.text = "Title: "+movie.title
//        rating.text = "Rating : "+movie.vote_average.toString()
    }
}