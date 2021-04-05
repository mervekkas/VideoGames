package com.mrvk.videogames.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("id") @Expose
    private var id: Int?,
    @SerializedName("title")
    @Expose
    private val title: String?,

    @SerializedName("count")
    @Expose
    private val count: Int?,

    @SerializedName("percent")
    @Expose
    private var percent: Double?
) {
}