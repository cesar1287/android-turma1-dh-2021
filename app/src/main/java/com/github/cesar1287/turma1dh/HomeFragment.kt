package com.github.cesar1287.turma1dh

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.github.cesar1287.turma1dh.databinding.FragmentHomeBinding
import com.google.android.material.datepicker.MaterialDatePicker

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btSplashMovies?.text = "Alterei via fragment"

        binding?.btSplashAbout?.setOnClickListener {
//            val ehPar = 10 % 2 == 0
//            val bundle = Bundle()
//            bundle.putString("teste", "teste")
//            bundle.putInt("teste1", 2)
//            findNavController().navigate(
//                R.id.action_homeFragment_to_aboutFragment,
//                bundle
//            )

            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select date")
                    .setInputMode(MaterialDatePicker.INPUT_MODE_CALENDAR)
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build()

            activity?.let {
                datePicker.show(it.supportFragmentManager, "tag")
            }
        }

        binding?.tvHomeClickHere?.setOnClickListener {
            Toast.makeText(context, "Você clicou no botão", Toast.LENGTH_SHORT).show()
        }

        binding?.btSplashMovies?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_nav_graph_movies)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}