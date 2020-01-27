package com.example.firstmodule

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Handler
import android.util.Log


class RecyclerViewPractice : AppCompatActivity() {
    val mlayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    lateinit var recyclerView: RecyclerView
    val users = ArrayList<DisplayList>()
    var count = 1
    lateinit var  imageView :ImageView
    lateinit var adapter: RecyclerViewAdapter1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_practice)

        recyclerView = findViewById<RecyclerView>(R.id.list)
        recyclerView.layoutManager = mlayoutManager

        addScrollListener()
        imageView= ImageView(this)
        imageView.setImageResource(R.drawable.ic_launcher_background)


        for (element in 1..10) {
            if (element % 10 == 1 && element != 1) {
                users.add(TitleData("$count"))
                count += 1
            }
            users.add(Person(element, "$element", imageView))
        }
        users.add(Loader())
        adapter = RecyclerViewAdapter1(users)
        recyclerView.adapter = adapter
    }


    var mIsLoading = false
    fun addScrollListener() {
        val mScrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (mIsLoading)
                    return
                val visibleItemCount = mlayoutManager.getChildCount()
                val totalItemCount = mlayoutManager.getItemCount()
                val pastVisibleItems = mlayoutManager.findFirstVisibleItemPosition()
                if (pastVisibleItems + visibleItemCount >= totalItemCount) {
                    Log.d("addScroll", "listener called")
                    mIsLoading=true
                    Handler().postDelayed( {addMoreElements()}, 1000)
                }
            }

        }
        recyclerView.addOnScrollListener(mScrollListener)
    }

    private fun addMoreElements(){
        Log.d("addMoreElements","called")
        //users.clear()

        users.remove(users.last())
        var temp=users.last()
        val id: Int = getId(temp as Person)
        for (element in id+1..id+10) {
            if (element % 10 == 1 && element != 1) {
                users.add(TitleData("$count"))
                count += 1
            }
            users.add(Person(element, "$element", imageView))
        }
        users.add(Loader())
        mIsLoading=false
        adapter.notifyDataSetChanged()
        //mIsLoading=false
    }
    fun getId(user:Person):Int{
        return user.position
    }

}
