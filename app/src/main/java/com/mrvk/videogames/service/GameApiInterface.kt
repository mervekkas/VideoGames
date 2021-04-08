package com.mrvk.videogames.service

import com.mrvk.videogames.model.Game
import com.mrvk.videogames.model.GameDetail
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameApiInterface {

    //https://api.rawg.io/api/games?page=2

    @GET("api/games")
    fun getGames(@Query("page") page:Int) : Single<Game>

    @GET("api/games/{id}")
    fun getDetail(@Path("id") gameId : Int) : Single<GameDetail>

}