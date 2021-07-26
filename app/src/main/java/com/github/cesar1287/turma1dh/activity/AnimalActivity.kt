package com.github.cesar1287.turma1dh.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.cesar1287.turma1dh.R
import com.github.cesar1287.turma1dh.adapter.AnimalAdapter
import com.github.cesar1287.turma1dh.databinding.ActivityAnimalBinding
import com.github.cesar1287.turma1dh.model.Animal

class AnimalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cat = Animal(
            name = "Gato",
            avatar = R.drawable.gato
        )

        val dog = Animal(
            name = "Cachorro",
            avatar = R.drawable.cachorro
        )

        val lion = Animal(
            name = "Leão",
            avatar = R.drawable.leao
        )

        val ounce = Animal(
            name = "Onça",
            avatar = R.drawable.onca
        )

        val animalList = listOf(cat, dog, lion, ounce)
        val animalAdapter = AnimalAdapter(animalList = animalList) {
            //todo fazer a chamada de outra tela
        }

        with(binding) {
            vgAnimalRecyclerView.layoutManager = LinearLayoutManager(this@AnimalActivity)
            vgAnimalRecyclerView.adapter = animalAdapter
        }
    }
}