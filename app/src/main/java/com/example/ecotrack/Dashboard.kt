package com.example.ecotrack

import android.content.Intent
import android.graphics.Camera
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ecotrack.databinding.ActivityDashboardBinding

class Dashboard : AppCompatActivity() {
    private val binding:ActivityDashboardBinding by lazy{
        ActivityDashboardBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.communityLogo.setOnClickListener {
            startActivity(Intent(this, CommunityChallenges::class.java))
            finish()
        }
        binding.tipsLogo.setOnClickListener{
            startActivity(Intent(this, TipsResources::class.java))
        }
        binding.wasteHist.setOnClickListener{
            startActivity(Intent(this,WasteHistory::class.java))
        }
        binding.logLogo.setOnClickListener{
            startActivity(Intent(this, LogWaste::class.java))
        }
    }
}