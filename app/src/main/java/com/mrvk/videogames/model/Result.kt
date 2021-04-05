package com.mrvk.videogames.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("id") @Expose
    private var id: Int?,
    @SerializedName("slug")
    @Expose
    private val slug: String?,

    @SerializedName("name")
    @Expose
    private val name: String?,

    @SerializedName("released")
    @Expose
    private val released: String?,

    @SerializedName("tba")
    @Expose
    private val tba: Boolean?,

    @SerializedName("background_image")
    @Expose
    private val backgroundImage: String?,

    @SerializedName("rating")
    @Expose
    private val rating: Double?,

    @SerializedName("rating_top")
    @Expose
    private val ratingTop: Int?,

    @SerializedName("ratings")
    @Expose
    private val ratings: List<Rating>?,

    @SerializedName("ratings_count")
    @Expose
    private var ratingsCount: Int? ) {
}