package com.github.cesar1287.turma1dh

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.github.cesar1287.turma1dh.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {

    private var binding: FragmentMoviesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btMoviesCalculate?.setOnClickListener {
            val weight = binding?.tilMoviesWeight?.editText?.text.toString()
            if (weight.isBlank()) {
                Toast.makeText(context, "Você digitou incorretamente", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}