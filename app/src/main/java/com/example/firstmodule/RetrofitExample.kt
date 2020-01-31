package com.example.firstmodule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_retrofit_example.*
import kotlinx.android.synthetic.main.fragment_screen_slide_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitExample : AppCompatActivity() {
    lateinit var posts:List<Post>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_example)

        val retrofit:Retrofit= Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()


        var jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)

        val call:Call<List<Post>> = jsonPlaceHolderApi.getPosts()
        call.enqueue(object: Callback<List<Post>>        //will be executed on different code
        {
            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                text_view_result.text=t?.message
            }

            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                if(!response!!.isSuccessful)
                {
                    text_view_result.text="Code"+response?.code()   //if the url is not found

                    return
                }
                var content:String=""
                posts= response.body()
                for(element in posts)
                {
                    content+="id"+element.id+"\n"
                    content+="userId:"+element.userId+"\n"
                    content+="text:"+element.text+"\n"
                    content+="title"+element.title+"\n"
                    text_view_result.append(content)
                }


            }

        })

    }

}
