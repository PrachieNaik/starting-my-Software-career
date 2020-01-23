package com.example.firstmodule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var button2: Button
class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        button2=findViewById(R.id.Button2)
        button2.setOnClickListener{
            intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}
