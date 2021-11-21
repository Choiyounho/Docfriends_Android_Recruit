package com.soten.solution.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soten.data.api.response.Company
import com.soten.solution.databinding.ItemCompanyBinding
import com.soten.solution.ui.home.adapter.viewholder.CompanyViewHolder

class CompanyAdapter(
    private val companyList: List<Company>
) : RecyclerView.Adapter<CompanyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {
        return CompanyViewHolder(
            ItemCompanyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        holder.bind(companyList[position])
    }

    override fun getItemCount(): Int = companyList.size

}