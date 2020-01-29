package com.example.firstmodule

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("body")
    val text: String,
    val userId:Int=0,
    val id:Int=0,
    val title:String=""
)