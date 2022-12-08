package com.example.project1.presentation.filmRus

import androidx.recyclerview.widget.RecyclerView
import com.example.project1.domain.ItemModel
import com.example.project1.databinding.ItemMovieBinding

class FilmRusViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: ItemModel){
        binding.image.setImageResource(movie.image)
        binding.title.text = movie.title
    }
}