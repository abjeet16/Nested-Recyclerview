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

        binding.mainRecyclerView.isNestedScrollingEnabled = false

        songsData1 = mutableListOf()
        songsData2 = mutableListOf()
        classificationData = mutableListOf()

        songsData1.add(childRecyclerView(SongImage = R.drawable.one, SongName = "one"))
        songsData1.add(childRecyclerView(SongImage = R.drawable.two, SongName = "two"))
        songsData1.add(childRecyclerView(SongImage = R.drawable.three, SongName = "three"))
        songsData1.add(childRecyclerView(SongImage = R.drawable.four, SongName = "four"))

        songsData2.add(childRecyclerView(SongImage = R.drawable.six, SongName = "five"))
        songsData2.add(childRecyclerView(SongImage = R.drawable.seven, SongName = "six"))
        songsData2.add(childRecyclerView(SongImage = R.drawable.eight, SongName = "seven"))
        songsData2.add(childRecyclerView(SongImage = R.drawable.one, SongName = "one"))

        classificationData.add(mainRecyclerView(title = "Classification 1", childRecyclerView = songsData1))
        classificationData.add(mainRecyclerView(title = "Classification 2", childRecyclerView = songsData2))

        Log.d("songData2", classificationData.toString())

        binding.mainRecyclerView.hasFixedSize()
        classificationAdapter = parentAdapter(classificationData)
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerView.adapter = classificationAdapter
    }
}