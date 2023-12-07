package com.example.testcasemagang

interface GameContract {
    interface View {
        fun showGames(games: List<Game>)
        fun showGameDetails(game: Game)
        fun showErrorMessage(error: String)
    }

    interface Presenter {
        fun getGames()
        fun getGameDetails(id: Int)
    }
}
