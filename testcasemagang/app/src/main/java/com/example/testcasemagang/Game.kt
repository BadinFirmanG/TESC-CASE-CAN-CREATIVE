package com.example.testcasemagang

data class Game(
    val id: Int,
    val name: String,
    val rating: Double,
    val released: String,
    val title: String,
)

data class GameResponse(val results: List<Game>)

val game = Game(name = "Nama Game", id = 1, title = "Judul Game", released = "2022-01-01", rating = 4.5)

val gameTitle = game.title
