package com.example.project1.presentation.filmRus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project1.domain.ItemModel
import com.example.project1.R
import com.example.project1.databinding.FilmsRusBinding


class FilmRus : Fragment() {

    lateinit var binding: FilmsRusBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FilmsRusBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = ItemModel(R.drawable.green_mile1, "asdamsdkaskdna", "dsfafas")
        val adapter = FilmRusAdapter(List(6) { data })
        binding.rvFilmsRus.adapter = adapter
    }
}