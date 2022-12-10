package com.example.project1.presentation.filmKaz

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project1.data.MovieRepository
import com.example.project1.domain.tmdb.MovieResults
import com.example.project1.domain.tmdb.TmdbMovie
import kotlinx.coroutines.launch

class FilmKazViewModel(
    private val repository: MovieRepository
) : ViewModel(){


    val movieCategories = MutableLiveData<List<TmdbMovie>>()
    var movies = listOf<TmdbMovie>()
    val movieDetails = MutableLiveData<TmdbMovie>()

    init {
        loadPopularMovies()
    }

    fun loadPopularMovies() {
        viewModelScope.launch {
            val results =repository.getPopularMovies(1)
//            for(i in 1..5){
//                results+=repository.getPopularMovies(1)
//                movies = movies + results[1].tmdbMovies
//            }
            movieCategories.value = results.tmdbMovies
            Log.d("Get zapros", "${results.tmdbMovies}")
        }
    }

    fun loadMovieDetails(movieId:Int){
        viewModelScope.launch {
            val results = repository.getMovieDetails(movieId)
            movieDetails.value = results
        }
    }
}