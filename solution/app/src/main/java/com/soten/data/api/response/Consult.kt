package com.soten.data.api.response


import com.google.gson.annotations.SerializedName

data class Consult(
    @SerializedName("answerCnt")
    val answerCnt: Int?,
    @SerializedName("context")
    val context: String?,
    @SerializedName("regDate")
    val regDate: Long?,
    @SerializedName("seq")
    val seq: Int?,
    @SerializedName("tagList")
    val tagList: List<Tag>?,
    @SerializedName("title")
    val title: String?,
)