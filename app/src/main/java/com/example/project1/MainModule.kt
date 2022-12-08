package com.example.project1

import com.example.project1.data.MovieRepository
import com.example.project1.presentation.filmKaz.FilmKazViewModel
import com.example.project1.presentation.filmRus.FilmRusViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory { MovieRepository(get()) }
    viewModel { FilmKazViewModel(get()) }
    viewModel { FilmRusViewModel(get()) }
}