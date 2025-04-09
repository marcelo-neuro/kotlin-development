package com.example.placar

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.placar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var playerScore1 = 0
    private var playerScore2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        setUpExtras(savedInstanceState)

        setUpListeners()
    }

    private fun setUpListeners() {
        binding.btPlayerOneScore.setOnClickListener {
            playerScore1++
            binding.tvPlayerOneScore.text = playerScore1.toString()
        }

        binding.btPlayerTwoScore.setOnClickListener {
            playerScore2++
            binding.tvPlayerTwoScore.text = playerScore2.toString()
        }


    }

    private fun setUpExtras(savedInstanceState: Bundle?) {
        binding.tvPlayerOneName.text = intent.getStringExtra("PLAYER1")
        binding.tvPlayerTwoName.text = intent.getStringExtra("PLAYER2")

        if(savedInstanceState != null) {
            playerScore1 = savedInstanceState.getInt("PLAYER_SCORE1")
            playerScore2 = savedInstanceState.getInt("PLAYER_SCORE2")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("PLAYER_SCORE1", playerScore1)
        outState.putInt("PLAYER_SCORE2", playerScore2)
    }
}