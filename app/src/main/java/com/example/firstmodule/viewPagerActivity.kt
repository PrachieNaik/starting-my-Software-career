package com.example.firstmodule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_view_pager.*


class viewPagerActivity : AppCompatActivity() {
    private val firstFragment = IntroFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        setSupportActionBar(toolbar)

        val adapter = IntroViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(IntroFragment.newInstance("1"), "A")
        adapter.addFragment(IntroFragment.newInstance("2"), "B")
        adapter.addFragment(IntroFragment.newInstance("3"), "C")

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }


}
