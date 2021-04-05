package com.mrvk.videogames.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Year__1(
    @SerializedName("year") @Expose
    var year: Int?,
    @SerializedName("count")
    @Expose
    val count: Int?,

    @SerializedName("nofollow")
    @Expose
    var nofollow: Boolean?
) {
}