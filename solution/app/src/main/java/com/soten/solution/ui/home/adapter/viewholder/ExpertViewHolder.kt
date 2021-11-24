package com.soten.solution.ui.home.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.soten.data.api.response.Expert
import com.soten.extensions.load
import com.soten.solution.databinding.ItemExpertBinding

class ExpertViewHolder(
    private val binding: ItemExpertBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(expert: Expert) {
        binding.expert = expert

        val width = binding.root.resources.displayMetrics.widthPixels / 2
        binding.root.layoutParams = binding.root.layoutParams.apply {
            this.width = width
        }

        expert.tagList?.forEach { tag ->
            binding.tagListChipGroup.addView(
                Chip(binding.root.context).apply {
                    text = tag.name
                }
            )
        }
        binding.profileImage.load(expert.profileImagePath)
        binding.executePendingBindings()
    }

}