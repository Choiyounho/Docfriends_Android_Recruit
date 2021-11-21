package com.soten.solution.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soten.data.api.response.DocFriendsResponse
import com.soten.data.repository.DocFriendsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val docFriendsRepository: DocFriendsRepository
) : ViewModel() {

    private val _docFriendsLiveData = MutableLiveData<DocFriendsResponse>()
    val docFriendsLiveData: LiveData<DocFriendsResponse> get() = _docFriendsLiveData

    init {
        initData()
    }

    private fun initData() = viewModelScope.launch {
        _docFriendsLiveData.value = docFriendsRepository.getConsultApi()
        try {
            Log.d("TestT", "data : ${_docFriendsLiveData.value}")
        } catch (e: Exception) {
            Log.d("TestT", "data : 실패")
        }
    }

}