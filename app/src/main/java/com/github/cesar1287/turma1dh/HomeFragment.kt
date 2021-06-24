package com.github.cesar1287.turma1dh

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.github.cesar1287.turma1dh.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btSplashAbout?.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("teste", "teste")
            bundle.putInt("teste1", 2)
            findNavController().navigate(
                R.id.action_homeFragment_to_aboutFragment,
                bundle
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}