package com.example.nestedrecyclearview.dataClasses

data class mainRecyclerView(
    val title: String,
    val childRecyclerView: List<childRecyclerView>
)
