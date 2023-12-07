package com.example.testcasemagang

import androidx.room.Dao
import androidx.room.Query
import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.OnConflictStrategy



@Dao
interface GameDao {
    @Query("SELECT * FROM games WHERE isFavorite = 1")
    fun getFavoriteGames(): LiveData<List<GameEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game: GameEntity)

    @Delete
    suspend fun deleteGame(game: GameEntity)
}


