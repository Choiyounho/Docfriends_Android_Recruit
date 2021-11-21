package com.soten.data.api.response


import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("key")
    val key: Int?,
    @SerializedName("name")
    val name: String?
)