package com.soten.solution.ui.home.adapter.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.soten.domain.model.HomeItem
import com.soten.solution.databinding.ItemCompanyListBinding
import com.soten.solution.databinding.ItemConsultBinding
import com.soten.solution.databinding.ItemExpertListBinding
import com.soten.solution.ui.home.adapter.CompanyAdapter
import com.soten.solution.ui.home.adapter.ExpertAdapter

sealed class DocFriendsViewHolder(
    binding: ViewDataBinding,
) : RecyclerView.ViewHolder(binding.root) {

    class ConsultViewHolder(
        private val binding: ItemConsultBinding,
    ) : DocFriendsViewHolder(binding) {

        fun bind(homeItem: HomeItem.ItemConsult) {
            binding.consult = homeItem.consult

            homeItem.consult.tagList?.forEach { tag ->
                binding.tagListChipGroup.addView(
                    Chip(binding.root.context).apply {
                        text = tag.name
                    }
                )
            }
            binding.executePendingBindings()
        }
    }

    class CompanyListViewHolder(
        private val binding: ItemCompanyListBinding,
    ) : DocFriendsViewHolder(binding) {

        fun bind(homeItem: HomeItem.ItemCompanyList) {
            binding.companyListViewPager.adapter = CompanyAdapter(homeItem.companyList)
            binding.executePendingBindings()
        }

    }

    class ExpertListViewHolder(
        private val binding: ItemExpertListBinding,
    ) : DocFriendsViewHolder(binding) {

        fun bind(homeItem: HomeItem.ItemExpertList) {
            binding.expertListViewPager.adapter =
                ExpertAdapter(homeItem.expertList)
            binding.executePendingBindings()
        }
    }

}