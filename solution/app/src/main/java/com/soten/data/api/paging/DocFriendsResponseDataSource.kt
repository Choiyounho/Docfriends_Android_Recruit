package com.soten.data.api.paging

import androidx.paging.DataSource
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.soten.data.api.DocFriendsApi
import com.soten.data.api.response.DocFriendsResponse
import com.soten.domain.model.HomeItem
import javax.inject.Inject

class DocFriendsResponseDataSource @Inject constructor(
    private val docFriendsApi: DocFriendsApi
) : PagingSource<Int, HomeItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HomeItem> {
        val page = params.key ?: 1
        return try {
            val response = docFriendsApi.getConsultApi()

            val homeItemList = mutableListOf<HomeItem>()

            val consultList = response.consultList as MutableList
            val expertList = response.expertList ?: emptyList()
            val companyList = response.companyList ?: emptyList()

            val expertListPosition = response.expertListPosition?.minus(1) ?: 3
            val companyListPosition = response.companyListPosition?.minus(1) ?: 7


            val count = response.pageMap?.totalCount?.plus(2) ?: 0

            for (i in 0 until count) {
                when (i) {
                    expertListPosition -> {
                        homeItemList.add(HomeItem.ItemExpertList(expertList))
                    }
                    companyListPosition -> {
                        homeItemList.add(HomeItem.ItemCompanyList(companyList))
                    }
                    else -> {
                        homeItemList.add(HomeItem.ItemConsult(consultList.first()))
                        consultList.removeFirst()
                    }
                }
            }

            LoadResult.Page(
                homeItemList,
                prevKey = null,
                nextKey = if (response.consultList.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, HomeItem>): Int? {
        return null
    }

}