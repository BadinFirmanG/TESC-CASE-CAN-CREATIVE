package com.example.testcasemagang

class GameRepository {
    fun fetchGames(callback: (List<Game>) -> Unit) {

        val games: List<Game> = listOf()
        callback(games)
    }
}
