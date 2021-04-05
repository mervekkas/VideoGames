package com.mrvk.videogames.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameDetailViewModel : ViewModel() {

    val gameDetailErroMessage = MutableLiveData<Boolean>()
    val loadingDetail = MutableLiveData<Boolean>()

    fun refreshDetailData() {

        gameDetailErroMessage.value = false
        loadingDetail.value = false
    }
}
