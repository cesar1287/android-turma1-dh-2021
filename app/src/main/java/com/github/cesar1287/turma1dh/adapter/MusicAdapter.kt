package com.github.cesar1287.turma1dh.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.cesar1287.turma1dh.databinding.MusicItemBinding
import com.github.cesar1287.turma1dh.databinding.MusicItemViewType2Binding
import com.github.cesar1287.turma1dh.model.Music
import com.github.cesar1287.turma1dh.utils.OnClickListenerMusic

class MusicAdapter(
    private val musicList: List<Music>,
    private val onClickListenerMusic: OnClickListenerMusic,
    private val onClickListener: (music: Music) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_DEFAULT) {
            val binding = MusicItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            ViewHolder(binding)
        } else {
            val binding = MusicItemViewType2Binding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            ViewHolderBlack(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(musicList[position], onClickListenerMusic)
        } else if (holder is ViewHolderBlack) {
            holder.bind(musicList[position], onClickListener)
        }
    }

    override fun getItemCount() = musicList.size

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) {
            VIEW_TYPE_BLACK
        } else {
            VIEW_TYPE_DEFAULT
        }
    }

    class ViewHolder(
        val binding: MusicItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            music: Music,
            onClickListenerMusic: OnClickListenerMusic,
        ) {
            binding.tvMusicItemName.text = music.name
            binding.tvMusicItemArtist.text = music.artist
            binding.vgMusicItemContainer.setOnClickListener {
                onClickListenerMusic.onClickListener(music)
            }
        }
    }

    class ViewHolderBlack(
        val binding: MusicItemViewType2Binding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            music: Music,
            onClickListener: (music: Music) -> Unit
        ) {
            binding.tvMusicItemName.text = music.name
            binding.tvMusicItemArtist.text = music.artist
            binding.vgMusicItemContainer.setOnClickListener {
                onClickListener(music)
            }
        }
    }

    companion object {
        const val VIEW_TYPE_DEFAULT = 1
        const val VIEW_TYPE_BLACK = 2
    }
}