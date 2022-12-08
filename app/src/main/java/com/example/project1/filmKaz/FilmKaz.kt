package com.example.project1.filmKaz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.project1.ItemModel
import com.example.project1.R
import com.example.project1.databinding.FilmsKazBinding

class FilmKaz : Fragment() {
    lateinit var binding: FilmsKazBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View {
            binding = FilmsKazBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val data = ItemModel(R.drawable.ana, "asdamsdkaskdna")

            val adapter = FilmKazAdapter(List(6){data})

            binding.rvFilmsKaz.adapter = adapter
        }
    }