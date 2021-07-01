package com.github.cesar1287.turma1dh

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.github.cesar1287.turma1dh.databinding.FragmentPaymentBinding
import com.google.android.material.tabs.TabLayout

class PaymentFragment : Fragment() {

    private var binding: FragmentPaymentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPaymentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentsList = listOf(Tab1Fragment(), Tab2Fragment(), Tab3Fragment())
        val fragmentsTitleList = listOf("Xpto", "Xuxa 021", "Eliana 03")

        activity?.let {
            val viewPagerAdapter = ViewPagerAdapter(
                fragmentManager = it.supportFragmentManager,
                fragmentsList = fragmentsList,
                fragmentsTitleList = fragmentsTitleList
            )

            binding?.let {  bindingNonNull ->
                with(bindingNonNull) {
                    vpPaymentTabs.adapter = viewPagerAdapter
                    tlPaymentTabs.setupWithViewPager(vpPaymentTabs)
                }
            }
        }

//        binding?.tlPaymentTabs?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                Log.i("tab - selected", tab?.text.toString())
//                when(tab?.position) {
//                    0 -> {
//                        goToFragment(Tab1Fragment())
//                    }
//                    1 -> {
//                        goToFragment(Tab2Fragment())
//                    }
//                    2 -> {
//                        goToFragment(Tab3Fragment())
//                    }
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                Log.i("tab - unselected", tab?.text.toString())
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                Log.i("tab - reselected", tab?.text.toString())
//            }
//        })
    }

//    fun goToFragment(fragment: Fragment) {
//        val fragmentTransaction = activity?.supportFragmentManager?.beginTransaction()
//        fragmentTransaction?.replace(R.id.container, fragment)
//        fragmentTransaction?.commit()
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}