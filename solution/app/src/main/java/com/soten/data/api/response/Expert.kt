package com.soten.data.api.response


import com.google.gson.annotations.SerializedName

data class Expert(
    @SerializedName("companyName")
    val companyName: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("profileImagePath")
    val profileImagePath: String?,
    @SerializedName("tagList")
    val tagList: List<TagX>?,
    @SerializedName("typeName")
    val typeName: String?
)