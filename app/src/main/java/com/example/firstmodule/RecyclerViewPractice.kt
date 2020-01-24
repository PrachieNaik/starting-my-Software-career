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

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        //crating an arraylist to store users using the data class user
        val users = ArrayList<PersonDataClass>()
        val imageView = ImageView(this)
        imageView.setImageResource(R.drawable.ic_launcher_background)
        //adding some dummy data to the listn
        for(element in 1..20)
        {
            users.add(PersonDataClass("$element",imageView))
        }


        //creating our adapter
        val adapter = RecyclerViewAdapter(users)

        //now adding the adapter to recyclerview
        recyclerView.adapter = adapter


    }
}
