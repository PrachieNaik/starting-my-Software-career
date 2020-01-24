package com.example.firstmodule

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_practice)
        val recyclerView = findViewById(R.id.list) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val users = ArrayList<PersonDataClass>()
        val imageView = ImageView(this)
        imageView.setImageResource(R.drawable.ic_launcher_background)
        for(element in 1..100)
        {
            users.add(PersonDataClass(element,"$element",imageView))
        }
        val adapter = RecyclerViewAdapter(users)
        recyclerView.adapter = adapter


    }
}
