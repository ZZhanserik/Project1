package com.example.project1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController

class Catalog : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_films, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bF1 = view.findViewById<ImageButton>(R.id.rus)
        val bF2 = view.findViewById<ImageButton>(R.id.kaz)
        val cont2 = findNavController()
        bF1.setOnClickListener { cont2.navigate(R.id.filmKaz) }
        bF2.setOnClickListener { cont2.navigate(R.id.filmRus) }
    }
}