package com.github.cesar1287.turma1dh.sharedchallenge

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.github.cesar1287.turma1dh.databinding.ActivitySplashScreenSharedBinding

class SplashScreenSharedActivity : AppCompatActivity() {

    private val binding: ActivitySplashScreenSharedBinding by lazy {
        ActivitySplashScreenSharedBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler().postDelayed({
            startActivity(Intent(this@SplashScreenSharedActivity, HomeSharedActivity::class.java))
        }, 2000L)
    }
}