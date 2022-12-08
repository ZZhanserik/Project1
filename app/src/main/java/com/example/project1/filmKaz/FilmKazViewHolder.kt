package com.example.project1.filmKaz


import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.project1.ItemModel
import com.example.project1.databinding.ItemMovieBinding

class FilmKazViewHolder(val binding: ItemMovieBinding): ViewHolder(binding.root) {



        fun bind(movie: ItemModel){
            binding.image.setImageResource(movie.image)
            binding.title.text = movie.title
        }
    }