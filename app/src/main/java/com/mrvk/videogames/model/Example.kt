package com.mrvk.videogames.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Example(
    @SerializedName("WARNING") @Expose
    var warning: String?,

    @SerializedName("count")
    @Expose
    private val count: Int?,

    @SerializedName("next")
    @Expose
    private val next: String?,

    @SerializedName("previous")
    @Expose
    private val previous: String?,

    @SerializedName("results")
    @Expose
    private val results: List<Result>?,

    @SerializedName("seo_title")
    @Expose
    private val seoTitle: String?,

    @SerializedName("seo_description")
    @Expose
    private val seoDescription: String?,

    @SerializedName("seo_keywords")
    @Expose
    private val seoKeywords: String?,

    @SerializedName("seo_h1")
    @Expose
    private val seoH1: String?,

    @SerializedName("noindex")
    @Expose
    private val noindex: Boolean?,

    @SerializedName("nofollow")
    @Expose
    private val nofollow: Boolean?,

    @SerializedName("description")
    @Expose
    private val description: String?,

    @SerializedName("filters")
    @Expose
    private val filters: Filters?,

    @SerializedName("nofollow_collections")
    @Expose
    private var nofollowCollections: MutableList<String?>?
) {
}