package com.example.nestedrecyclearview.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclearview.dataClasses.mainRecyclerView
import com.example.nestedrecyclearview.databinding.MainRecyclerViewLayoutBinding

class parentAdapter(private val songClassificationData: List<mainRecyclerView>): RecyclerView.Adapter<parentAdapter.ViewHolder>() {
    inner class ViewHolder (val binding: MainRecyclerViewLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.classificationName.text = songClassificationData[position].title
            val childAdapter = childAdapter(songClassificationData[position].childRecyclerView)
            binding.childRecyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            binding.childRecyclerView.adapter = childAdapter
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MainRecyclerViewLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = songClassificationData.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }
}