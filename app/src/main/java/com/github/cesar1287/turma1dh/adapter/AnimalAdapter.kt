package com.github.cesar1287.turma1dh.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.cesar1287.turma1dh.databinding.AnimalItemBinding
import com.github.cesar1287.turma1dh.databinding.MusicItemBinding
import com.github.cesar1287.turma1dh.databinding.MusicItemViewType2Binding
import com.github.cesar1287.turma1dh.model.Animal
import com.github.cesar1287.turma1dh.model.Music
import com.github.cesar1287.turma1dh.utils.OnClickListenerMusic

class AnimalAdapter(
    private val animalList: List<Animal>,
    private val onClickListener: (animal: Animal) -> Unit
) : RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AnimalItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(animalList[position], onClickListener)
    }

    override fun getItemCount() = animalList.size

    class ViewHolder(
        val binding: AnimalItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            animal: Animal,
            onClickListener: (animal: Animal) -> Unit,
        ) {
            with(binding) {
                tvAnimalName.text = animal.name
                ivAnimalAvatar.setImageResource(animal.avatar)
                vgAnimalContainer.setOnClickListener {
                    onClickListener(animal)
                }
            }
        }
    }
}