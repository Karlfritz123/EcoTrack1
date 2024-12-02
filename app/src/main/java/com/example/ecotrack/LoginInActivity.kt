package com.example.ecotrack

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ecotrack.databinding.ActivityLoginInBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginInActivity : AppCompatActivity() {
    private val binding:ActivityLoginInBinding by lazy {
        ActivityLoginInBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        auth = FirebaseAuth.getInstance()
        binding.loginButton.setOnClickListener{
            val userName = binding.userName.text.toString()
            val password = binding.password.text.toString()

            if(userName.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
            }
            else{
                auth.signInWithEmailAndPassword(userName, password)
                    .addOnCompleteListener (this){ task ->
                        if(task.isSuccessful){
                            Toast.makeText(this, "Sign in successful", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, Dashboard::class.java))
                            finish()
                        }
                        else{
                            Toast.makeText(this, "Sign in failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

        setContentView(binding.root)
        binding.signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }
    }
}