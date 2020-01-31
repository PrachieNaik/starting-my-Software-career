package com.example.firstmodule.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student (

    val name:String,
    val course:String

){
    @PrimaryKey(autoGenerate = true)
    val id:Int=0
}