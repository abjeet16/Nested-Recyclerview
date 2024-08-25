package com.example.nestedrecyclearview.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclearview.dataClasses.childRecyclerView
import com.example.nestedrecyclearview.databinding.ChildRecyclerViewLayoutBinding

class childAdapter(private val SongsData: List<childRecyclerView>) : RecyclerView.Adapter<childAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ChildRecyclerViewLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val song = SongsData[position]
            Log.d("childAdapter", "Binding position: $position with data: $song")

            // Check if the image resource is valid
            if (song.SongImage != 0) {
                binding.SongImage.setImageResource(song.SongImage)
            } else {
                Log.e("childAdapter", "Invalid image resource ID at position $position")
            }

            binding.SongName.text = song.SongName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ChildRecyclerViewLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = SongsData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }
}
