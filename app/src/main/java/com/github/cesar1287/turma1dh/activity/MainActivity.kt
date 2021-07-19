package com.github.cesar1287.turma1dh.activity

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.github.cesar1287.turma1dh.R
import com.github.cesar1287.turma1dh.databinding.ActivityMainBinding
import com.github.cesar1287.turma1dh.utils.toEditable
import com.github.cesar1287.turma1dh.utils.getText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("personal_data", MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("lifecycle", "onCreate")
//        val editor = sharedPreferences.edit()
//        editor.putString("name", "César")
//        editor.putBoolean("isSaved", true)
//        editor.apply()

//        sharedPreferences.edit {
//            putString("email", "cnascimento@digitalhouse.com")
//            putBoolean("xpto", false)
//        }

        binding.btSave.setOnClickListener {
            saveUserData(sharedPreferences)
        }


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

    private fun saveUserData(sharedPreferences: SharedPreferences) {
        with(binding) {
            val name = etName.getText()
            val email = etEmail.getText()
            val gender = etGender.getText()
            val phone = etPhone.getText()
            val day = etDay.getText()
            val month = etMonth.getText()
            val year = etYear.getText()
            val date = "$day/$month/$year"

            sharedPreferences.edit {
                putString(KEY_SHARED_NAME, name)
                putString(KEY_SHARED_EMAIL, email)
                putString(KEY_SHARED_GENDER, gender)
                putString(KEY_SHARED_PHONE, phone)
                putString(KEY_SHARED_DATE, date)
            }

            Snackbar.make(
                btSave,
                getString(R.string.data_saved_successfully),
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    override fun onResume() {
        super.onResume()

        getUserData()

        Log.i("lifecycle", "onResume")
    }

    private fun getUserData() {
        with(sharedPreferences) {
            val name = getString(KEY_SHARED_NAME, "")
            val phone = getString(KEY_SHARED_PHONE, "")
            val email = getString(KEY_SHARED_EMAIL, "")
            val gender = getString(KEY_SHARED_GENDER, "")
            val date = getString(KEY_SHARED_DATE, "")

            with(binding) {
                etName.editText?.text = name.toEditable()
                etPhone.editText?.text = phone.toEditable()
                etEmail.editText?.text = email.toEditable()
                etGender.editText?.text = gender.toEditable()
            }
        }
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
        const val KEY_SHARED_NAME = "name"
        const val KEY_SHARED_EMAIL = "email"
        const val KEY_SHARED_GENDER = "gender"
        const val KEY_SHARED_PHONE = "phone"
        const val KEY_SHARED_DATE = "date"
    }
}