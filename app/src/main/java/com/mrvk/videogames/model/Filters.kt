package com.mrvk.videogames.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("years") @Expose
    var years: List<Year?>?
) {
}