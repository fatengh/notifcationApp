package com.example.notifcationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notifcationapp.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}