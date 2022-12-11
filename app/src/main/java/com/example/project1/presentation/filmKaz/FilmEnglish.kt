package com.example.project1.presentation.filmKaz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.project1.databinding.FilmsKazBinding

class FilmEnglish : Fragment() {
    lateinit var binding: FilmsKazBinding
    lateinit var adapter: FilmEnglishAdapter

    private val viewModel: FilmEnglishViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FilmsKazBinding.inflate(inflater, container, false)
        adapter = FilmEnglishAdapter(::onItemClick)
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

    private fun onItemClick(movieId: Int) {
        MovieDetailsEngBottomSheet(movieId).show(parentFragmentManager, null)
    }
}