package com.example.firstmodule

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_practice)

        val recyclerView = findViewById<RecyclerView>(R.id.list)
        recyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false) as RecyclerView.LayoutManager?

        val users = ArrayList<DisplayList>()
        val imageView = ImageView(this)
        imageView.setImageResource(R.drawable.ic_launcher_background)
        var count=1
        for (element in 1..100) {
            if (element % 10 == 1 && element != 1)
            {
                users.add(TitleData("$count"))
                count += 1
            }
            users.add(Person(element, "$element", imageView))
        }

        val adapter = RecyclerViewAdapter1(users)
        recyclerView.adapter = adapter
    }
}
