package com.soten.data.repository

import androidx.paging.PagingData
import com.soten.domain.model.HomeItem
import kotlinx.coroutines.flow.Flow

interface PagingRepository {

    fun getDocFriendsPagingData(): Flow<PagingData<HomeItem>>

}