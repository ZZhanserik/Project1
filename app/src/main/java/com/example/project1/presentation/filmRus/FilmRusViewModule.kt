package com.example.project1.presentation.filmRus

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project1.data.MovieRepository
import com.example.project1.domain.tmdb.TmdbMovie
import kotlinx.coroutines.launch

class FilmRusViewModel(
    private val repository: MovieRepository
) : ViewModel() {


    val movieCategories = MutableLiveData<List<TmdbMovie>>()
    var movies = listOf<TmdbMovie>()
    val movieDetails = MutableLiveData<TmdbMovie>()

    init {
        loadPopularMoviesInRussian()
    }

    fun loadPopularMoviesInRussian() {
        viewModelScope.launch {
            for (i in 1..5) {
                val results = repository.getPopularMovies(page = i, language = "ru")
                movies = movies + results.tmdbMovies
            }
            movieCategories.value = movies
        }
    }

    fun loadMovieDetails(movieId: Int) {
        viewModelScope.launch {
            val results = repository.getMovieDetails(movieId = movieId, language = "ru")
            movieDetails.value = results
        }
    }
}