package com.soten.data.api.response


import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

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
) {

    fun regDateToKoreaTimeFormat(regDate: Long): String {
        return SimpleDateFormat("yyyy.MM.dd", Locale.KOREA).format(regDate)
    }

}