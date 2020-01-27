package com.example.firstmodule

import android.widget.ImageView

class Person(
    val position: Int,
    val id: String,
    val image: ImageView,
    var checked: Boolean = false
):DisplayList{
    override fun getType(): ItemType {

        return ItemType.LIST_ITEM
    }
}