package com.example.project1.presentation.filmKaz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.project1.databinding.BottomSheetMovieDetailsBinding
import com.example.project1.utils.Constants.imageUrl
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MovieDetailsEngBottomSheet(val movieId:Int): BottomSheetDialogFragment() {

    private val viewModel : FilmEnglishViewModel by sharedViewModel()

    private var _binding: BottomSheetMovieDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetMovieDetailsBinding.inflate(inflater, container, false)

        viewModel.loadMovieDetails(movieId)
        viewModel.movieDetails.observe(viewLifecycleOwner) {movie ->
            binding.tvDetails.text = movie.overview
            Glide.with(requireContext())
                .load(imageUrl+movie.posterPath)
                .into(binding.ivPoster)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}