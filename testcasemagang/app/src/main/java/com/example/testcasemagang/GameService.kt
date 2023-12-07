package com.example.testcasemagang

import retrofit2.Call
import retrofit2.http.GET

interface GameService {

    @GET("games")
    fun getGames(): Call<List<Game>>


}


