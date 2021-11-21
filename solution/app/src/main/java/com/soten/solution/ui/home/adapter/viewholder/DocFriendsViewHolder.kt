package com.soten.solution.ui.home.adapter.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.soten.data.api.response.Company
import com.soten.data.api.response.Consult
import com.soten.extensions.load
import com.soten.solution.databinding.ItemCompanyBinding
import com.soten.solution.databinding.ItemConsultBinding

sealed class DocFriendsViewHolder(
    binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    class CompanyViewHolder(
        private val binding: ItemCompanyBinding
    ) : DocFriendsViewHolder(binding) {

        fun bind(company: Company) {
            binding.company = company
            binding.introImage.load(company.introPath ?: "")
        }

    }

    class ConsultViewHolder(
        private val binding: ItemConsultBinding,
    ) : DocFriendsViewHolder(binding) {

        fun bind(consult: Consult) {
            binding.consult = consult
            binding.tagListChipGroup.removeAllViews()
            consult.tagList?.forEach { tag ->
                binding.tagListChipGroup.addView(
                    Chip(binding.root.context).apply {
                        text = tag.name
                    }
                )
            }
        }
    }

}