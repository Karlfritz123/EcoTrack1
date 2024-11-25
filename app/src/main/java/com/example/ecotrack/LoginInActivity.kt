package com.example.ecotrack

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ecotrack.databinding.ActivityLoginInBinding
import com.google.firebase.auth.FirebaseAuth

class LoginInActivity : AppCompatActivity() {
    private val binding:ActivityLoginInBinding by lazy {
        ActivityLoginInBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.button2.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }
    }
}