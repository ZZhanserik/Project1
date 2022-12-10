package com.example.project1.presentation.filmKaz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.project1.domain.ItemModel
import com.example.project1.R
import com.example.project1.databinding.FilmsKazBinding

class FilmKaz : Fragment() {
    lateinit var binding: FilmsKazBinding
    lateinit var adapter:FilmKazAdapter

    private val viewModel: FilmKazViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View {
            binding = FilmsKazBinding.inflate(inflater, container, false)
            adapter = FilmKazAdapter()
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            viewModel.movieCategories.observe(viewLifecycleOwner) { movieCategories ->
                adapter.mList = movieCategories
                adapter.notifyDataSetChanged()
            }

            binding.rvFilmsKaz.adapter = adapter
        }
    }