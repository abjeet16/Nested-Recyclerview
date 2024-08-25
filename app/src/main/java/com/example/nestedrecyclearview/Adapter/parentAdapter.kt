package com.example.nestedrecyclearview.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclearview.dataClasses.mainRecyclerView
import com.example.nestedrecyclearview.databinding.MainRecyclerViewLayoutBinding

class parentAdapter(private val songClassificationData: List<mainRecyclerView>) : RecyclerView.Adapter<parentAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: MainRecyclerViewLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        private val childLayoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        private lateinit var childAdapter: childAdapter

        fun bind(position: Int) {
            val currentData = songClassificationData[position]

            // Set the classification name for the TextView
            binding.classificationName.text = currentData.title

            // Initialize Child Adapter if not initialized
            if (!::childAdapter.isInitialized) {
                childAdapter = childAdapter(currentData.childRecyclerView)
                binding.childRecyclerView.apply {
                    setHasFixedSize(true)
                    layoutManager = childLayoutManager
                    adapter = childAdapter
                }
            } else {
                // Update child adapter data if needed
                //childAdapter.updateData(currentData.childRecyclerView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MainRecyclerViewLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = songClassificationData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }
}
