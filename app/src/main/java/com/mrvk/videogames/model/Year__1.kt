package com.mrvk.videogames.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Year__1(
    @SerializedName("year") @Expose
    private var year: Int?,
    @SerializedName("count")
    @Expose
    private val count: Int?,

    @SerializedName("nofollow")
    @Expose
    private var nofollow: Boolean?
) {
}