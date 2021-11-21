package com.soten.solution.ui.home.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.soten.data.api.response.Company
import com.soten.extensions.load
import com.soten.solution.databinding.ItemCompanyBinding

class CompanyViewHolder(
    private val binding: ItemCompanyBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(company: Company) {
        binding.company = company
        binding.introImage.load(company.introPath ?: "")
        binding.executePendingBindings()
    }

}