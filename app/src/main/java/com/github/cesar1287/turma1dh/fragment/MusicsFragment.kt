package com.github.cesar1287.turma1dh.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.cesar1287.turma1dh.adapter.MusicAdapter
import com.github.cesar1287.turma1dh.databinding.FragmentMusicsBinding
import com.github.cesar1287.turma1dh.model.Music

class MusicsFragment : Fragment() {

    private var binding: FragmentMusicsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val music1 = Music(
            name = "Love of my life",
            artist = "Queen"
        )
        val music2 = Music(
            name = "Bohemian Rhapsody",
            artist = "Queen"
        )
        val music3 = Music(
            name = "Talking to the moon",
            artist = "Bruno Mars"
        )
        val music4 = Music(
            name = "Dr Mr President",
            artist = "P1nk!"
        )
        val music5 = Music(
            name = "Sabão crá crá",
            artist = "Mamonas Assassinas"
        )
        val music6 = Music(
            name = "Evidências",
            artist = "Chitãozinha & Xoxoró"
        )
        val music7 = Music(
            name = "Blow your trumpets Gabriel",
            artist = "Behemoth"
        )
        val music8 = Music(
            name = "Amarelo",
            artist = "Emicida"
        )
        val music9 = Music(
            name = "Florentina",
            artist = "Tiririca"
        )
        val music10 = Music(
            name = "Beggin",
            artist = "Madcon"
        )
        val music11 = Music(
            name = "Boa esperança",
            artist = "Emicida"
        )
        val music12 = Music(
            name = "Ta rocheda",
            artist = "Barões da Pisadinha"
        )
        val music13 = Music(
            name = "Believer",
            artist = "Imagine Dragons"
        )
        val music14 = Music(
            name = "Radioactive",
            artist = "Image Dragons"
        )
        val music15 = Music(
            name = "Volta comigo bebê",
            artist = "Zé Vaqueiro"
        )
        val music16 = Music(
            name = "Esquema preferido",
            artist = "Barões da Pisadinha"
        )
        val musicList = listOf(music1, music2, music3, music4,
            music5, music6, music7, music8,
            music9, music10, music11, music12,
            music13, music14, music15, music16
        )

        val musicAdapter = MusicAdapter(
            musicList = musicList
        )
        binding?.let {
            with(it) {
                vgMusicsRecyclerView.layoutManager = LinearLayoutManager(context)
                vgMusicsRecyclerView.adapter = musicAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}