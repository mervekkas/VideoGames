package com.mrvk.videogames.service

import com.mrvk.videogames.model.Game
import io.reactivex.Single
import retrofit2.http.GET

interface GameApiInterface {

    //https://api.rawg.io/api/games?page=2

    @GET("api/games")
    fun getGames() : Single<Game>
}