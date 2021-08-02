package com.github.cesar1287.turma1dh.shareNativo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.cesar1287.turma1dh.R
import com.github.cesar1287.turma1dh.databinding.ActivityShareNativoBinding

class ShareNativoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShareNativoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareNativoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val shared = intent.action
        if (shared == Intent.ACTION_SEND) {

        }

        binding.btShare.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_EMAIL, "Olá, estou com um problema e gostaria de uma solução")
                putExtra(Intent.EXTRA_SUBJECT, "Suporte ao usuário")
                putExtra(Intent.EXTRA_CC, "cnascimento@digitalhouse.com")
                putExtra(Intent.EXTRA_BCC, "lucas@digitalhouse.com")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(intent, "Compartilhe nosso app")
            startActivity(shareIntent)
        }
    }
}