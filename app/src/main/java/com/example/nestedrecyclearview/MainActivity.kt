package com.example.nestedrecyclearview

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedrecyclearview.Adapter.parentAdapter
import com.example.nestedrecyclearview.dataClasses.childRecyclerView
import com.example.nestedrecyclearview.dataClasses.mainRecyclerView
import com.example.nestedrecyclearview.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var classificationAdapter: parentAdapter
    lateinit var classificationData: MutableList<mainRecyclerView>
    lateinit var songsData1: MutableList<childRecyclerView>
    lateinit var songsData2: MutableList<childRecyclerView>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        songsData1 = mutableListOf()
        songsData2 = mutableListOf()
        classificationData = mutableListOf()

        songsData1.add(childRecyclerView(SongImage = R.drawable.randomimage2, SongName = "one"))
        songsData1.add(childRecyclerView(SongImage = R.drawable.randomimage2, SongName = "two"))
        songsData1.add(childRecyclerView(SongImage = R.drawable.randomimage2, SongName = "three"))
        songsData1.add(childRecyclerView(SongImage = R.drawable.randomimage2, SongName = "four"))

        songsData2.add(childRecyclerView(SongImage = R.drawable.randomimage2, SongName = "five"))
        songsData2.add(childRecyclerView(SongImage = R.drawable.randomimage2, SongName = "six"))
        songsData2.add(childRecyclerView(SongImage = R.drawable.randomimage2, SongName = "seven"))
        songsData2.add(childRecyclerView(SongImage = R.drawable.randomimage2, SongName = "one"))

        classificationData.add(mainRecyclerView(title = "Classification 1", childRecyclerView = songsData1))
        classificationData.add(mainRecyclerView(title = "Classification 2", childRecyclerView = songsData2))

        Log.d("songData2", classificationData.toString())

        classificationAdapter = parentAdapter(classificationData)
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerView.adapter = classificationAdapter
    }
}