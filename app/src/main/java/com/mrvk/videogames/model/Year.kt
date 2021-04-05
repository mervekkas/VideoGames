package com.mrvk.videogames.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Year(
    @SerializedName("from") @Expose
    var from: Int?,
    @SerializedName("to")
    @Expose
    val to: Int?,

    @SerializedName("filter")
    @Expose
    val filter: String?,

    @SerializedName("decade")
    @Expose
    val decade: Int?,

    @SerializedName("years")
    @Expose
    val years: List<Year__1>?,

    @SerializedName("nofollow")
    @Expose
    val nofollow: Boolean?,

    @SerializedName("count")
    @Expose
    var count: Int?
) {
}