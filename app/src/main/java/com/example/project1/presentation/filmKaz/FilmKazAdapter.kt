package com.example.project1.presentation.filmKaz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project1.domain.ItemModel
import com.example.project1.databinding.ItemMovieBinding
import com.example.project1.domain.tmdb.TmdbMovie


    class FilmKazAdapter() : RecyclerView.Adapter<FilmKazViewHolder>() {

        var mList: List<TmdbMovie> = mutableListOf()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmKazViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
            return FilmKazViewHolder(binding)
        }
        override fun getItemCount(): Int {
            return mList.size
        }
        override fun onBindViewHolder(holder: FilmKazViewHolder, position: Int) {
            holder.bind(mList[position])
        }
    }