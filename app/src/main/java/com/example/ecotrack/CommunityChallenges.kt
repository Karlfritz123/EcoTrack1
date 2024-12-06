package com.example.ecotrack

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ecotrack.databinding.ActivityCommunityChallengesBinding

class CommunityChallenges : AppCompatActivity() {
    private val binding: ActivityCommunityChallengesBinding by lazy{
        ActivityCommunityChallengesBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_community_challenges)
    }
}