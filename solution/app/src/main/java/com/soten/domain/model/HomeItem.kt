package com.soten.domain.model

import com.soten.data.api.response.Company
import com.soten.data.api.response.Consult
import com.soten.data.api.response.Expert

sealed class HomeItem {

    data class ItemConsult(val consult: Consult) : HomeItem()
    data class ItemExpertList(val expertList: List<Expert>) : HomeItem()
    data class ItemCompanyList(val companyList: List<Company>) : HomeItem()

}
