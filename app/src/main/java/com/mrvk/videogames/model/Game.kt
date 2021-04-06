package com.mrvk.videogames.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Game(
    @SerializedName("WARNING") @Expose
    var warning: String?,
    @SerializedName("count")
    @Expose
    val count: Int?,

    @SerializedName("next")
    @Expose
    val next: String?,

    @SerializedName("previous")
    @Expose
    val previous: String?,

    @SerializedName("results")
    @Expose
    val results: List<Result>?,

    @SerializedName("seo_title")
    @Expose
    val seoTitle: String?,

    @SerializedName("seo_description")
    @Expose
    val seoDescription: String?,

    @SerializedName("seo_keywords")
    @Expose
    val seoKeywords: String?,

    @SerializedName("seo_h1")
    @Expose
    val seoH1: String?,

    @SerializedName("noindex")
    @Expose
    val noindex: Boolean?,

    @SerializedName("nofollow")
    @Expose
    val nofollow: Boolean?,

    @SerializedName("description")
    @Expose
    val description: String?,

    @SerializedName("filters")
    @Expose
    val filters: Filters?,

    @SerializedName("nofollow_collections")
    @Expose
    val nofollowCollections: List<String>?
) {
}