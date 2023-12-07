package com.example.testcasemagang

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class GamePresenter(private val view: GameContract.View, private val service: RawgApiService) : GameContract.Presenter {
    override fun getGames() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = service.getGames()
                if (response.isSuccessful) {
                    val games = response.body()?.results ?: emptyList()
                    withContext(Dispatchers.Main) {
                        view.showGames(games)
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        view.showErrorMessage("Failed to fetch games")
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    view.showErrorMessage("Error: ${e.message}")
                }
            }
        }
    }

    override fun getGameDetails(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = service.getGameDetails(id)
                if (response.isSuccessful) {
                    val game = response.body()
                    game?.let {
                        withContext(Dispatchers.Main) {
                            view.showGameDetails(it)
                        }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        view.showErrorMessage("Failed to fetch game details")
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    view.showErrorMessage("Error: ${e.message}")
                }
            }
        }
    }
}
