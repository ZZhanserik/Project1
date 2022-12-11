package com.example.project1.data.network

import com.example.project1.domain.tmdb.MovieResults
import com.example.project1.domain.tmdb.TmdbMovie
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


private const val API_KEY = "98cb0edb3aa4f4039e949d171e615e66"

interface MovieService {

    @GET("movie/popular")
    suspend fun getMovie(
        @Query("api_key") apiKey:String = API_KEY,
        @Query("page") page: Int,
        @Query("language") language: String,
    ): MovieResults

    @GET("movie/{kino_id}")
    suspend fun getMovieDetails(
        @Path("kino_id") movieId: Int,
        @Query("api_key") apiKey:String = API_KEY,
        @Query("language") language: String,
    ): TmdbMovie
}