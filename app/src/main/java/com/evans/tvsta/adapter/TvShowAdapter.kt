package com.evans.tvsta.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.evans.tvsta.databinding.TvShowLayoutAdapterBinding
import com.evans.tvsta.models.TvShowResponseItem

//add adapter after instantiating in mainactivity before viewholder

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding: TvShowLayoutAdapterBinding):
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<TvShowResponseItem>(){
        override fun areItemsTheSame(
            oldItem: TvShowResponseItem,
            newItem: TvShowResponseItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: TvShowResponseItem,
            newItem: TvShowResponseItem
        ): Boolean {
            return newItem == oldItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var tvShows: List<TvShowResponseItem>
    get() = differ.currentList
    set(value) {
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(TvShowLayoutAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTvShow = tvShows[position]

        holder.binding.apply {
            textView.text= currentTvShow.name

            //picasso or this time coil
            imageView.load(currentTvShow.image.original) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun getItemCount() = tvShows.size

}