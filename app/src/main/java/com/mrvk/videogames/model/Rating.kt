package com.mrvk.videogames.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("id") @Expose
    var id: Int?,
    @SerializedName("title")
    @Expose
    val title: String?,

    @SerializedName("count")
    @Expose
    val count: Int?,

    @SerializedName("percent")
    @Expose
    var percent: Double?
) {
}