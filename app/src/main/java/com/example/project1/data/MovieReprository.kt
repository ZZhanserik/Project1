package com.example.project1.data

import com.example.project1.data.network.MovieService
import com.example.project1.domain.tmdb.MovieResults
import com.example.project1.domain.tmdb.TmdbMovie
import retrofit2.Retrofit

class MovieRepository(private val retrofit: Retrofit) {

    val service = retrofit.create(MovieService::class.java)

    suspend fun getPopularMovies(page: Int, language: String): MovieResults {
        return service.getMovie(page = page, language = language)
    }

    suspend fun getMovieDetails(movieId: Int, language: String): TmdbMovie {
        return service.getMovieDetails(movieId = movieId, language = language)
    }
}