package com.example.project1.presentation.filmRus

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project1.databinding.ItemMovieBinding
import com.example.project1.domain.tmdb.TmdbMovie

class FilmRusAdapter(private val onClick: (Int) -> Unit = {}) : RecyclerView.Adapter<FilmRusViewHolder>() {

    var mList: List<TmdbMovie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmRusViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(layoutInflater, parent, false)
        return FilmRusViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: FilmRusViewHolder, position: Int) {
        holder.bind(mList[position], onClick)
    }
}