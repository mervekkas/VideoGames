package com.mrvk.videogames.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrvk.videogames.adapter.GameRecyclerAdapter
import com.mrvk.videogames.model.Game
import com.mrvk.videogames.model.Result
import com.mrvk.videogames.service.GamesApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class GameListViewModel : ViewModel() {
    val gameList = MutableLiveData<List<Result>>()
    val gameErroMessage = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()
    var pageCount = 1

    private val gamesApiService = GamesApiService()
    private val disposable = CompositeDisposable()

    fun refreshListData() {
        dataResponse()
    }

    private fun dataResponse(pageNo: Int?= 1) {
        loading.value = true
        disposable.add(
            gamesApiService.getGames(pageNo ?: 1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Game>() {
                    override fun onSuccess(t: Game) {
                        t.results?.let {
                            onSuccesValue(it)
                        }
                    }

                    override fun onError(e: Throwable) {
                        onErrorValue(e)
                    }

                })
        )
    }

    private fun onErrorValue(e: Throwable) {
        gameErroMessage.value = true
        loading.value = false
        gameList.value = mutableListOf()
        e.printStackTrace()
    }

    private fun onSuccesValue(gameL: List<Result>) {
        gameList.value = gameL
        gameErroMessage.value = false
        loading.value = false
    }

    fun getMoreData() {
        dataResponse(pageCount++)
    }
}