package com.soten.solution.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soten.data.api.response.DocFriendsResponse
import com.soten.data.repository.DocFriendsRepository
import com.soten.domain.model.HomeItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val docFriendsRepository: DocFriendsRepository
) : ViewModel() {

    private val _docFriendsLiveData = MutableLiveData<DocFriendsResponse>()
    val docFriendsLiveData: LiveData<DocFriendsResponse> get() = _docFriendsLiveData

    private val _homeItemListLiveData = MutableLiveData<List<HomeItem>>()
    val homeItemListLiveData: LiveData<List<HomeItem>> get() = _homeItemListLiveData

    init {
        initData()
    }

    private fun initData() = viewModelScope.launch {
        _docFriendsLiveData.value = docFriendsRepository.getConsultApi()

        val consultList = docFriendsLiveData.value?.consultList as MutableList
        val expertList = docFriendsLiveData.value?.expertList ?: emptyList()
        val companyList = docFriendsLiveData.value?.companyList ?: emptyList()

        val expertListPosition = docFriendsLiveData.value?.expertListPosition?.minus(1) ?: 3
        val companyListPosition = docFriendsLiveData.value?.companyListPosition?.minus(1) ?: 7

        val homeItemList = mutableListOf<HomeItem>()

        val count = docFriendsLiveData.value?.pageMap?.totalCount?.plus(2)

        count ?: return@launch

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

        _homeItemListLiveData.value = homeItemList
    }

}