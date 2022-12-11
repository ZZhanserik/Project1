package com.example.project1.presentation.filmRus


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.project1.databinding.FilmsRusBinding


class FilmRus : Fragment() {

    lateinit var binding: FilmsRusBinding
    lateinit var adapter: FilmRusAdapter
    private val viewModel: FilmRusViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FilmsRusBinding.inflate(inflater, container, false)
        adapter = FilmRusAdapter(::onItemClick)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.movieCategories.observe(viewLifecycleOwner) { movieCategories ->
            adapter.mList = movieCategories
            adapter.notifyDataSetChanged()
        }
        binding.rvFilmsRus.adapter = adapter
    }
    private fun onItemClick(movieId: Int) {
        MovieDetailsRuBottomSheet(movieId).show(parentFragmentManager, null)
    }
}