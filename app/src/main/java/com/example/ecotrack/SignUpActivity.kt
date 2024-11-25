package com.example.ecotrack

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ecotrack.databinding.ActivitySignUpBinding


class SignUpActivity : AppCompatActivity() {
    private val binding: ActivitySignUpBinding by lazy{
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startActivity(Intent(this, LoginInActivity::class.java))
            finish()
        }
    }
}