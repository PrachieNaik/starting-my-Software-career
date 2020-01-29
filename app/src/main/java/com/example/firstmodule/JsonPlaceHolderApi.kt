package com.example.firstmodule

import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderApi {
    @GET("posts")           //Relative url in https://jsonplaceholder.typicode.com/posts
    fun getPosts(): Call<List<Post>>
}