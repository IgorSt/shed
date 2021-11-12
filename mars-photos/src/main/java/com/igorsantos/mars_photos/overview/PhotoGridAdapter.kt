package com.igorsantos.mars_photos.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.igorsantos.mars_photos.databinding.GridViewItemBinding
import com.igorsantos.mars_photos.network.MarsPhoto

/**
 * Created by IgorSantos on 8/20/2021.
 */
class PhotoGridAdapter : ListAdapter<MarsPhoto,
        PhotoGridAdapter.MarsPhotoViewHolder>(DiffCallback){

        class MarsPhotoViewHolder(
                val binding: GridViewItemBinding
        ) : RecyclerView.ViewHolder(binding.root){
                fun bind(MarsPhoto: MarsPhoto){
                        binding.photo = MarsPhoto
                        binding.executePendingBindings()
                }
        }

        companion object DiffCallback : DiffUtil.ItemCallback<MarsPhoto>(){

                override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
                        return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
                        return oldItem.imgSrcUrl == newItem.imgSrcUrl
                }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotoViewHolder {
                return MarsPhotoViewHolder(
                        GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
                )
        }

        override fun onBindViewHolder(holder: MarsPhotoViewHolder, position: Int) {
                val marsPhoto = getItem(position)
                holder.bind(marsPhoto)
        }
}