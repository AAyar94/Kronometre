package com.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import com.kronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        var pausedtime:Long = 0

        binding.startbutton.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime() + pausedtime
            binding.chronometer.start()
            binding.startbutton.visibility = View.GONE
            binding.pausebutton.visibility = View.VISIBLE

        }
        binding.pausebutton.setOnClickListener {
            binding.chronometer.stop()
            pausedtime = binding.chronometer.base - SystemClock.elapsedRealtime()
            binding.startbutton.visibility = View.VISIBLE
            binding.pausebutton.visibility = View.GONE
        }
        binding.resetbutton.setOnClickListener {
            binding.chronometer.stop()
            pausedtime = 0
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.startbutton.visibility = View.VISIBLE
            binding.pausebutton.visibility = View.GONE
        }



    }
}