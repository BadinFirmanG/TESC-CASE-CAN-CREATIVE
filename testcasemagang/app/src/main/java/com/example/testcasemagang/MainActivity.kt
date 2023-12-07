package com.example.testcasemagang

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testcasemagang.GameRepository

class MainActivity : AppCompatActivity() {

    private lateinit var gameRepository: GameRepository
    private lateinit var recyclerView: RecyclerView
    private lateinit var gameAdapter: GameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameRepository = GameRepository()

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        gameAdapter = GameAdapter(listOf())
        recyclerView.adapter = gameAdapter

        fetchGamesData()
    }

    private fun fetchGamesData() {
        gameRepository.fetchGames { games ->
            runOnUiThread {
                // Update RecyclerView with the fetched games
                gameAdapter.updateGames(games)
            }
        }
    }
}
