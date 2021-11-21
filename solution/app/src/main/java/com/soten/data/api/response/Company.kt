package com.soten.data.api.response


import com.google.gson.annotations.SerializedName

data class Company(
    @SerializedName("address")
    val address: String?,
    @SerializedName("addressEtc")
    val addressEtc: String?,
    @SerializedName("companyName")
    val companyName: String?,
    @SerializedName("introPath")
    val introPath: String?
)