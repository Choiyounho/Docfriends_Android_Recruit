package com.soten.data.repository

import com.soten.data.api.DocFriendsApi
import com.soten.data.api.response.DocFriendsResponse
import javax.inject.Inject

class DocFriendsRepositoryImpl @Inject constructor(
    private val docFriendsApi: DocFriendsApi
) : DocFriendsRepository {

    override suspend fun getConsultApi(): DocFriendsResponse {
        return docFriendsApi.getConsultApi()
    }

}