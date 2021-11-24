package com.soten.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.soten.data.api.DocFriendsApi
import com.soten.data.api.paging.DocFriendsResponseDataSource
import com.soten.domain.model.HomeItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PagingRepositoryImpl @Inject constructor(
    private val docFriendsApi: DocFriendsApi
) : PagingRepository {

    override fun getDocFriendsPagingData(): Flow<PagingData<HomeItem>> {
        val pagingData = DocFriendsResponseDataSource(docFriendsApi)

        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = true
            ),
            pagingSourceFactory = {
                pagingData
            }
        ).flow
    }

}