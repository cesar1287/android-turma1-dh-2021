package com.github.cesar1287.turma1dh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.github.cesar1287.turma1dh.MainActivity.Companion.KEY_INTENT_SALDO
import com.github.cesar1287.turma1dh.MainActivity.Companion.KEY_INTENT_SALDO_LONG
import com.github.cesar1287.turma1dh.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nome = intent.getStringExtra(MainActivity.KEY_INTENT_NOME)
        val saldo = intent.getDoubleExtra(KEY_INTENT_SALDO, 0.0)
        val saldoLong = intent.getLongExtra(KEY_INTENT_SALDO_LONG, 0L)

        Log.i("resultIntent", "Meu nome é - $nome " +
                "e meu saldo é $saldo, meu saldo em long é $saldoLong")

        Log.i("lifecycle - splash", "onCreate")

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setupWithNavController(binding.bottomNavigation, navController)

        //Tela 1 - Calculadora de IMC
        //Tela 2 - Form de login/cadastro
        //Tela 3 - Sobre vocês

//        val bundle = Bundle()
//        bundle.putString("testeString", "xpto")
//        bundle.putDouble("testeDouble", 1.0)
//        bundle.putFloat("testeFloat", 1.0f)
//
//        val bundle1 = Bundle().apply {
//            putString("testeString", "xpto")
//            putDouble("testeDouble", 1.0)
//            putFloat("testeFloat", 1.0f)
//        }.also {
//            Log.i("xpto", "Bundle instanciado com sucesso")
//        }
//
//        bundle1?.let {
//            it.getString()
//            it.getDouble()
//        }
//
//        bundle1.getString()
//        bundle1.getDouble()
//
//        with(bundle1) {
//            getString()
//            getDouble()
//        }

        /*
        Activity -> Navigation -> Activity
         */
    }

    override fun onResume() {
        super.onResume()

        Log.i("lifecycle - splash", "onResume")
    }

    override fun onStart() {
        super.onStart()

        Log.i("lifecycle - splash", "onStart")
    }

    override fun onPause() {
        super.onPause()

        Log.i("lifecycle - splash", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("lifecycle - splash", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("lifecycle - splash", "onDestroy")
    }
}