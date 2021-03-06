package com.github.cesar1287.turma1dh.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.cesar1287.turma1dh.adapter.MusicCatalogViewPager
import com.github.cesar1287.turma1dh.fragment.MusicsFragment
import com.github.cesar1287.turma1dh.databinding.ActivityMusicCatalogBinding
import com.github.cesar1287.turma1dh.fragment.AlbumsFragment
import com.github.cesar1287.turma1dh.fragment.ImagesFragment

class MusicCatalogActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMusicCatalogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicCatalogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragments = listOf(MusicsFragment(), ImagesFragment(), AlbumsFragment())
        val fragmentsPageTitle = listOf("Músicas", "Imagens", "Álbuns")
        val musicCatalogViewPager = MusicCatalogViewPager(
            fragments = fragments,
            fragmentManager = supportFragmentManager,
            fragmentsPageTitle = fragmentsPageTitle
        )

        with(binding) {
            vwMusicCatalogPager.adapter = musicCatalogViewPager
            tlMusicCatalogTabs.setupWithViewPager(vwMusicCatalogPager)
        }
    }
}