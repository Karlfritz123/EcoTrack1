package com.example.ecotrack

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ecotrack.databinding.ActivitySignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class SignUpActivity : AppCompatActivity() {
    private val binding: ActivitySignUpBinding by lazy{
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    private lateinit var auth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.buttonAlreadyHaveAccount.setOnClickListener{
            startActivity(Intent(this, LoginInActivity::class.java))
            finish()
        }
        binding.registerButton.setOnClickListener{
            val userName = binding.userName.text.toString()
            val phone = binding.phone.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if(userName.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show()
            }
            else{
                auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this){task ->
                        if(task.isSuccessful){
                            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, LoginInActivity::class.java))
                            finish()
                        }
                        else{
                            Toast.makeText(this, "Registration Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}