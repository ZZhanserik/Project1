package com.example.project1.presentation.filmKaz

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.project1.R
import com.example.project1.databinding.ItemMovieBinding
import com.example.project1.domain.tmdb.TmdbMovie
import com.example.project1.utils.Constants.imageUrl

class FilmEnglishViewHolder(val binding: ItemMovieBinding): ViewHolder(binding.root) {

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