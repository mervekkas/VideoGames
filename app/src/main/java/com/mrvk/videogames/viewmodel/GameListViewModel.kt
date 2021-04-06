package com.mrvk.videogames.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    private val gamesApiService =GamesApiService()
    private val disposable = CompositeDisposable()

    fun refreshListData() {
       dataResponse()
    }

    private fun dataResponse() {
        loading.value = true
        disposable.add(
            gamesApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Game>() {
                    override fun onSuccess(t: Game) {
                        gameList.value = t.results
                        gameErroMessage.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        gameErroMessage.value = true
                        loading.value = false
                        e.printStackTrace()
                    }

                }))

    }
}