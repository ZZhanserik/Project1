package com.example.project1.presentation.filmKaz

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.project1.R
import com.example.project1.domain.ItemModel
import com.example.project1.databinding.ItemMovieBinding
import com.example.project1.domain.tmdb.TmdbMovie

class FilmKazViewHolder(val binding: ItemMovieBinding): ViewHolder(binding.root) {

    fun bind(movie: TmdbMovie){
        binding.image.setImageResource(R.drawable.green_mile1)
        binding.title.text = movie.title
    }
}