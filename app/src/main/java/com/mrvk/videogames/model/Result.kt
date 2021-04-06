package com.mrvk.videogames.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("id") @Expose
    var id: Int?,
    @SerializedName("slug")
    @Expose
    val slug: String?,

    @SerializedName("name")
    @Expose
    val name: String?,

    @SerializedName("released")
    @Expose
    val released: String?,

    @SerializedName("tba")
    @Expose
    val tba: Boolean?,

    @SerializedName("background_image")
    @Expose
    val backgroundImage: String?,

    @SerializedName("rating")
    @Expose
    val rating: Double?,

    @SerializedName("rating_top")
    @Expose
    val ratingTop: Int?,

    @SerializedName("ratings")
    @Expose
    val ratings: List<Rating>?,

    @SerializedName("ratings_count")
    @Expose
    val ratingsCount: Int?
) {
}