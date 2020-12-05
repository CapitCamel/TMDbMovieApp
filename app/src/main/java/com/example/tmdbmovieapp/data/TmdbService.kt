package com.example.tmdbmovieapp.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TmdbService {
    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(TmdbEndpoints::class.java)


    fun buildService(): TmdbEndpoints {
        return retrofit
    }
}