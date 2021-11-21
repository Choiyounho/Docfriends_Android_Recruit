package com.soten.data.api.response


import com.google.gson.annotations.SerializedName

data class DocFriendsResponse(
    @SerializedName("companyList")
    val companyList: List<Company>?,
    @SerializedName("companyListPosition")
    val companyListPosition: Int?,
    @SerializedName("consultList")
    val consultList: List<Consult>?,
    @SerializedName("expertList")
    val expertList: List<Expert>?,
    @SerializedName("expertListPosition")
    val expertListPosition: Int?,
    @SerializedName("pageMap")
    val pageMap: PageMap?
)