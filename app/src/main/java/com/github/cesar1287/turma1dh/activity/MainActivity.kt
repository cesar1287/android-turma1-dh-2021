package com.github.cesar1287.turma1dh.activity

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.edit
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.github.cesar1287.turma1dh.R
import com.github.cesar1287.turma1dh.databinding.ActivityMainBinding
import com.github.cesar1287.turma1dh.utils.MyBroadcastReceiver
import com.github.cesar1287.turma1dh.utils.UploadWorker
import com.github.cesar1287.turma1dh.utils.toEditable
import com.github.cesar1287.turma1dh.utils.getText
import com.google.android.material.snackbar.Snackbar
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("personal_data", MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myBroadcastReceiver = MyBroadcastReceiver()
        val filter = IntentFilter().apply {
            addAction("com.example.broadcast.TURMADH1")
        }
        registerReceiver(myBroadcastReceiver, filter)

        Intent().also { intent ->
            intent.action = "com.example.broadcast.TURMADH1"
            intent.putExtra("data", "Notice me senpai!")
            sendBroadcast(intent)
        }

        val uploadWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<UploadWorker>()
                .setInitialDelay(30, TimeUnit.SECONDS)
                .build()

        WorkManager
            .getInstance(this)
            .enqueue(uploadWorkRequest)

        // Register the permissions callback, which handles the user's response to the
        // system permissions dialog. Save the return value, an instance of
        // ActivityResultLauncher. You can use either a val, as shown in this snippet,
        // or a lateinit var in your onAttach() or onCreate() method.
        val requestPermissionLauncher =
            registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted: Boolean ->
                if (isGranted) {
                    Snackbar.make(
                        binding.btSave,
                        "Permissão de localização concedida",
                        Snackbar.LENGTH_SHORT
                    ).show()
                } else {
                    Snackbar.make(
                        binding.btSave,
                        "Permissão de localização NEGADA, VAI SUBIR NINGUÉM",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }

        binding.btPermission?.setOnClickListener {
            when {
                ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED -> {
                    // You can use the API that requires the permission.
                    Snackbar.make(
                        binding.btSave,
                        "Permissão de localização já concedida",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    // You can directly ask for the permission.
                    // The registered ActivityResultCallback gets the result of this request.
                    requestPermissionLauncher.launch(
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                }
            }
        }

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