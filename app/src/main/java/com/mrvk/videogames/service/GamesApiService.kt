package com.mrvk.videogames.service

import com.mrvk.videogames.model.Game
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GamesApiService {

    //https://api.rawg.io/api/games?page=2

    private val BASE_URL = "https://api.rawg.io/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(GameApiInterface::class.java)

    fun getData() : Single<Game> {
        return api.getGames()
    }
}