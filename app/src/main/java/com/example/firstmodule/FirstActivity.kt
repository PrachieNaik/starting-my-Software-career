package com.example.firstmodule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

lateinit var button: Button
class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        button=findViewById(R.id.Button1)
        button.setOnClickListener{
            intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

}
