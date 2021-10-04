package com.evans.tvsta.models

data class TvShowResponseItem(
    val ended: String,
    val genres: List<String>,
    val id: Int,
    val image: Image,
    val name: String,
    val officialSite: String,
    val rating: Rating,
    val summary: String,
)