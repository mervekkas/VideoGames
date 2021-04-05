package com.mrvk.videogames.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Year(
    @SerializedName("from") @Expose
    private var from: Int?,
    @SerializedName("to")
    @Expose
    private val to: Int?,

    @SerializedName("filter")
    @Expose
    private val filter: String?,

    @SerializedName("decade")
    @Expose
    private val decade: Int?,

    @SerializedName("years")
    @Expose
    private val years: List<Year__1>?,

    @SerializedName("nofollow")
    @Expose
    private val nofollow: Boolean?,

    @SerializedName("count")
    @Expose
    private var count: Int?
) {
}