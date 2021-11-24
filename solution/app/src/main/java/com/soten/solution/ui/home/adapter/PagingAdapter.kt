package com.soten.solution.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.soten.domain.model.HomeItem
import com.soten.solution.R
import com.soten.solution.databinding.ItemCompanyListBinding
import com.soten.solution.databinding.ItemConsultBinding
import com.soten.solution.databinding.ItemExpertListBinding
import com.soten.solution.ui.home.adapter.viewholder.DocFriendsViewHolder

class PagingAdapter : PagingDataAdapter<HomeItem, DocFriendsViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocFriendsViewHolder {
        return when (viewType) {
            R.layout.item_company_list -> {
                DocFriendsViewHolder.CompanyListViewHolder(
                    ItemCompanyListBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            R.layout.item_expert_list -> {
                DocFriendsViewHolder.ExpertListViewHolder(
                    ItemExpertListBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            R.layout.item_consult -> {
                DocFriendsViewHolder.ConsultViewHolder(
                    ItemConsultBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> throw IllegalArgumentException("유효 하지 않습니다.")
        }
    }

    override fun onBindViewHolder(holder: DocFriendsViewHolder, position: Int) {
        val items = getItem(position)

        when (holder) {
            is DocFriendsViewHolder.CompanyListViewHolder ->
                holder.bind(items as? HomeItem.ItemCompanyList ?: return)
            is DocFriendsViewHolder.ExpertListViewHolder ->
                holder.bind(items as? HomeItem.ItemExpertList ?: return)
            is DocFriendsViewHolder.ConsultViewHolder ->
                holder.bind(items as? HomeItem.ItemConsult ?: return)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is HomeItem.ItemConsult -> R.layout.item_consult
            is HomeItem.ItemExpertList -> R.layout.item_expert_list
            is HomeItem.ItemCompanyList -> R.layout.item_company_list
            else -> throw IllegalArgumentException("실패")
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<HomeItem>() {
            override fun areItemsTheSame(
                oldItem: HomeItem,
                newItem: HomeItem,
            ): Boolean {
                return when {
                    oldItem is HomeItem.ItemConsult && newItem is HomeItem.ItemConsult -> {
                        oldItem.consult.seq == newItem.consult.seq
                    }
                    oldItem is HomeItem.ItemCompanyList && newItem is HomeItem.ItemCompanyList -> {
                        oldItem.companyList == newItem.companyList
                    }
                    oldItem is HomeItem.ItemExpertList && newItem is HomeItem.ItemExpertList -> {
                        oldItem.expertList == newItem.expertList
                    }
                    else -> false
                }
            }

            override fun areContentsTheSame(
                oldItem: HomeItem,
                newItem: HomeItem,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}