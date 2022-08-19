package com.wiprotask.telstra

import com.google.gson.annotations.SerializedName

data class Fact(
    @SerializedName("title") val title: String,
    @SerializedName("imageHref") val poster: String,
    @SerializedName("description") val description: String
)
