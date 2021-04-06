package com.mrvk.videogames.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrvk.videogames.model.GameDetail
import com.mrvk.videogames.model.Result
import com.mrvk.videogames.service.GamesApiService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class GameDetailViewModel : ViewModel() {
    val gameDetail = MutableLiveData<GameDetail>()
    val gameDetailErroMessage = MutableLiveData<Boolean>()
    val loadingDetail = MutableLiveData<Boolean>()

    private val gamesDetailApiService = GamesApiService()
    private val disposableDetail = CompositeDisposable()

    fun refreshDetailData(gameId: Int) {
        detailDataResponse(gameId)
    }

    fun detailDataResponse(gameId : Int) {
        if (gameId != -1){
            loadingDetail.value = true
            disposableDetail.add(
                gamesDetailApiService.getDetail(gameId)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableSingleObserver<GameDetail>() {
                        override fun onSuccess(t: GameDetail) {
                            onSuccesValue(t)
                        }

                        override fun onError(e: Throwable) {
                            onErrorValue(e)
                        }

                    })
            )
        }
    }

    private fun onSuccesValue(t: GameDetail) {
        gameDetailErroMessage.value = false
        loadingDetail.value = false
        gameDetail.value = t

    }

    private fun onErrorValue(e: Throwable) {
        gameDetailErroMessage.value = true
        loadingDetail.value = false
        e.printStackTrace()
    }
}
