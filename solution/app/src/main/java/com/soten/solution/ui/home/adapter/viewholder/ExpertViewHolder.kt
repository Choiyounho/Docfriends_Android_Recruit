package com.soten.solution.ui.home.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.soten.data.api.response.Expert
import com.soten.extensions.load
import com.soten.solution.databinding.ItemExpertBinding

class ExpertViewHolder(
    private val binding: ItemExpertBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(expert: Expert) {
        binding.expert = expert
        binding.profileImage.load(expert.profileImagePath)
        binding.executePendingBindings()
    }

}