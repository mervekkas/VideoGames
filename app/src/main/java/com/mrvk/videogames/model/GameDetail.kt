package com.mrvk.videogames.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GameDetail(
    @SerializedName("id") @Expose
    var id: Int?,
    @SerializedName("slug")
    @Expose
    val slug: String?,

    @SerializedName("name")
    @Expose
    val name: String?,

    @SerializedName("name_original")
    @Expose
    val nameOriginal: String?,

    @SerializedName("description")
    @Expose
    val description: String?,

    @SerializedName("metacritic")
    @Expose
    val metacritic: Int?,

    @SerializedName("released")
    @Expose
    val released: String?,

    @SerializedName("background_image")
    @Expose
    val backgroundImage: String?
) {
}