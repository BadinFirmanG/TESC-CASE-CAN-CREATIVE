package com.example.testcasemagang

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RawgApiService {
    @GET("6d78a1f98c4f48c283f1d655c5e38137")
    suspend fun getGames(): Response<GameResponse>

    @GET("games?page={page}&page_size={count}&key=6d78a1f98c4f48c283f1d655c5e38137")
    suspend fun getGamesPaging(@Path("page") page: Int, @Path("count") count: Int): Response<GameResponse>

    @GET("games?search={query}&key=6d78a1f98c4f48c283f1d655c5e38137")
    suspend fun searchGames(@Path("query") query: String): Response<GameResponse>

    @GET("games/{id}?key=6d78a1f98c4f48c283f1d655c5e38137")
    suspend fun getGameDetails(@Path("id") id: Int): Response<Game>
}

