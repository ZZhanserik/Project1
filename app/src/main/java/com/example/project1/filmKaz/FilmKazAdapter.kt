package com.example.project1.filmKaz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.project1.databinding.ItemMovieBinding

class FilmKazAdapter(private val mList: List<ItemsModel>):Adapter<FilmKazViewHolder>() {

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