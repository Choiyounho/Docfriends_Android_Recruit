package com.soten.solution.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.soten.data.repository.PagingRepository
import com.soten.domain.model.HomeItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pagingRepository: PagingRepository
) : ViewModel() {

    fun fetchPagingFlow(): Flow<PagingData<HomeItem>> {
        return pagingRepository.getDocFriendsPagingData()
            .cachedIn(viewModelScope)
    }

}