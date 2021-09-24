package com.fedx.listvideo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fedx.listvideo.databinding.ItemForRvBinding
import com.fedx.listvideo.network.Headline

import com.fedx.listvideo.network.ImgSrc


class DataAdapter():ListAdapter<Headline, DataAdapter.MoviesViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataAdapter.MoviesViewHolder {
        return MoviesViewHolder(ItemForRvBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: DataAdapter.MoviesViewHolder, position: Int) {
        val src = getItem(position)
        holder.bind(src)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Headline>() {
        override fun areItemsTheSame(oldItem: Headline, newItem: Headline): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Headline, newItem: Headline): Boolean {
            return oldItem.headline == newItem.headline
        }
    }

    class MoviesViewHolder(private var binding: ItemForRvBinding)
        :RecyclerView.ViewHolder(binding.root) {
            fun bind(movies: Headline){
                binding.tvHeader.text = movies.headline
                binding.tvDescription.text = movies.summary_short
                binding.imgSrc = movies.multimedia
                binding.executePendingBindings()
            }
        }
}