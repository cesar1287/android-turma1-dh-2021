package com.github.cesar1287.turma1dh.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.cesar1287.turma1dh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("lifecycle", "onCreate")

//        findViewById<Button>(R.id.helloWorld).setOnClickListener {
//            val intent = Intent(this@MainActivity, SplashActivity::class.java)
//            intent.putExtra(KEY_INTENT_NOME, "César Rodrigues")
//            intent.putExtra(KEY_INTENT_SALDO, 50.0)
//            intent.putExtra(KEY_INTENT_SALDO_LONG, 50L)
//            startActivity(intent)
//
//            //MainActivity -> pacote(Intent) -> SplashActivity
//        }
    }

    override fun onResume() {
        super.onResume()

        Log.i("lifecycle", "onResume")
    }

    override fun onStart() {
        super.onStart()

        Log.i("lifecycle", "onStart")
    }

    override fun onPause() {
        super.onPause()

        Log.i("lifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("lifecycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("lifecycle", "onDestroy")
    }

    companion object {
        const val KEY_INTENT_NOME = "nome1"
        const val KEY_INTENT_SALDO = "saldo1"
        const val KEY_INTENT_SALDO_LONG = "saldoLong1"
    }
}