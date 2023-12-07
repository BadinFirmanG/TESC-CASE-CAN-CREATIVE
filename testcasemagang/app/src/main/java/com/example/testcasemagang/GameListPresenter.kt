package com.example.testcasemagang

interface GameListPresenter {
    fun fetchGames()
    fun fetchNextPageOfGames(pageSize: Int)
    fun searchGames(query: String)
    fun detachView()

}



