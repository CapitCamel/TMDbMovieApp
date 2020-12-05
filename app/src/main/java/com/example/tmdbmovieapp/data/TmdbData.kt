package com.example.tmdbmovieapp.data

data class PopularMovies(
        val results: List<Result>,
        val genres: List<Genre>,
        val cast: List<Cast>,
        val production_countries: List<Country>,
        //val homepage: ResultDetail
        val id: Int,
        val overview: String,
        val title: String,
        val vote_count: Int,
        val poster_path: String,
        val vote_average: Double,
        val tagline: String,
        val release_date: String

)

data class Result(
        val id: Int,    val overview: String,
        val poster_path: String,
        val release_date: String,
        val title: String,
        val vote_average: Double,
        val vote_count: Int
)

data class Genre(
        val name: String
)

data class Country(
        val name: String
)

data class Cast(
        val name: String,
        val character: String,
        val profile_path: String
)