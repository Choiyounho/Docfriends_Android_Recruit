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

        val width = binding.root.resources.displayMetrics.widthPixels * 0.8
        binding.root.layoutParams = binding.root.layoutParams.apply {
            this.width = width.toInt()
        }

        binding.introImage.load(company.introPath ?: "")
        binding.executePendingBindings()
    }

}