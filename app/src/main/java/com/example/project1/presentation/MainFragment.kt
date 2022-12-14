package com.example.project1.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.findNavController
import com.example.project1.R

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mF = view.findViewById<Button>(R.id.startButton)
        val dF = view.findViewById<Button>(R.id.loginButton)
        val controller = view.findNavController()
        mF.setOnClickListener { controller.navigate(R.id.fragCat) }
        dF.setOnClickListener { controller.navigate(R.id.mainData) }
    }
}