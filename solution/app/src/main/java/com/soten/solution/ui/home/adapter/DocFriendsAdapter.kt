package com.soten.solution.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.soten.data.api.response.DocFriendsResponse
import com.soten.solution.R
import com.soten.solution.databinding.ItemCompanyBinding
import com.soten.solution.databinding.ItemConsultBinding
import com.soten.solution.ui.home.adapter.viewholder.DocFriendsViewHolder
import java.lang.IllegalArgumentException

class DocFriendsAdapter : ListAdapter<DocFriendsResponse, DocFriendsViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocFriendsViewHolder {
        return when (viewType) {
            R.layout.item_consult -> {
                DocFriendsViewHolder.ConsultViewHolder(
                    ItemConsultBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            R.layout.item_company -> {
                DocFriendsViewHolder.CompanyViewHolder(
                    ItemCompanyBinding.inflate(
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
        TODO("Not yet implemented")
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<DocFriendsResponse>() {
            override fun areItemsTheSame(
                oldItem: DocFriendsResponse,
                newItem: DocFriendsResponse
            ): Boolean {
                return oldItem.consultList?.get(0)?.seq == newItem.consultList?.get(0)?.seq
            }

            override fun areContentsTheSame(
                oldItem: DocFriendsResponse,
                newItem: DocFriendsResponse
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}