package com.example.nestedrecyclearview.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.nestedrecyclearview.R
import com.example.nestedrecyclearview.dataClasses.childRecyclerView
import com.example.nestedrecyclearview.databinding.ChildRecyclerViewLayoutBinding

class childAdapter(private val songsData: List<childRecyclerView>) : RecyclerView.Adapter<childAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ChildRecyclerViewLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val song = songsData[position]
            Log.d("ChildAdapter", "Binding position: $position with data: $song")

            // Load the image efficiently using Glide
            Glide.with(binding.SongImage.context)
                .load(song.SongImage)
                .placeholder(R.drawable.one)  // Placeholder image while loading
                .error(R.drawable.one)  // Error image if loading fails
                .diskCacheStrategy(DiskCacheStrategy.ALL) // Cache all versions of the image
                .override(200, 200)  // Resize the image to reduce memory usage
                .into(binding.SongImage)

            binding.SongName.text = song.SongName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ChildRecyclerViewLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = songsData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }
}

