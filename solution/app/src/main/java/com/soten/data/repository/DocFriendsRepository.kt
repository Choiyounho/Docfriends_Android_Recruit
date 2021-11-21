package com.soten.data.repository

import com.soten.data.api.response.DocFriendsResponse

interface DocFriendsRepository {

    suspend fun getConsultApi(): DocFriendsResponse

}