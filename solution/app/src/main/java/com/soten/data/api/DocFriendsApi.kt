package com.soten.data.api

import com.soten.data.api.response.DocFriendsResponse
import retrofit2.http.GET

interface DocFriendsApi {

    @GET("Docfriends_Android_Recruit/api/home.json")
    suspend fun getConsultApi(): DocFriendsResponse

}