package com.soten.solution.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soten.data.api.response.Expert
import com.soten.solution.databinding.ItemExpertBinding
import com.soten.solution.ui.home.adapter.viewholder.ExpertViewHolder

class ExpertAdapter(
    private val expertList: List<Expert>,
) : RecyclerView.Adapter<ExpertViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpertViewHolder {
        return ExpertViewHolder(
            ItemExpertBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ExpertViewHolder, position: Int) {
        holder.bind(expertList[position])
    }

    override fun getItemCount() = expertList.size
}