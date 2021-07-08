package com.github.cesar1287.turma1dh

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MusicCatalogViewPager(
    private val fragments: List<Fragment>,
    private val fragmentsPageTitle: List<String>,
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {

    override fun getCount() = fragments.size

    override fun getItem(position: Int) = fragments[position]

    override fun getPageTitle(position: Int) = fragmentsPageTitle[position]
}