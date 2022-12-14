package com.example.project1.presentation.filmRus

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project1.databinding.ItemMovieBinding
import com.example.project1.domain.tmdb.TmdbMovie
import com.example.project1.utils.Constants.imageUrl

class FilmRusViewHolder(private val binding: ItemMovieBinding, ): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: TmdbMovie, onClick:(Int)->Unit){

        Glide.with(itemView.context)
            .load(imageUrl + movie.posterPath)
            .into(binding.poster)
        binding.title.text = movie.title
        binding.poster.setOnClickListener{
            val id = movie.id ?: return@setOnClickListener
            onClick(id)
        }
    }
}