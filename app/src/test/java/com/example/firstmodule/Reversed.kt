package com.example.firstmodule

import org.junit.Test

class Reversed {
    var string: String= "Prachi"
    @Test
    fun main()
    {
//        var st=reverse("Prachi")      //similar to java--1
//        println(st)

 //       println(reverse(string))      //--2

              reverse(string)           //-3




    }
    //fun reverse( string:String): String{     //--1
    //    return string.reversed()
    //
    //}


    //fun reverse(string: String)=string.reversed() //--2

    fun reverse(string:String):Unit{          //--3
        println(string.reversed())
    }
}


