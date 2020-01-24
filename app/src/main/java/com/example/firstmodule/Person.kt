package com.example.firstmodule

import android.widget.ImageView

data class Person(
    val position: Int,
    val id: String,
    val image: ImageView,
    var checked: Boolean = false
)