package com.github.cesar1287.turma1dh.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.cesar1287.turma1dh.databinding.MusicItemBinding
import com.github.cesar1287.turma1dh.model.Music

class MusicAdapter(
    private val musicList: List<Music>
) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MusicItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(musicList[position])
    }

    override fun getItemCount() = musicList.size

    class ViewHolder(
        val binding: MusicItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            music: Music
        ) {
            binding.tvMusicItemName.text = music.name
            binding.tvMusicItemArtist.text = music.artist
        }
    }
}