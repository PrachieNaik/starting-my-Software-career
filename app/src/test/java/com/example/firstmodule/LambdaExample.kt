package com.example.firstmodule

import org.junit.Test

class LambdaExample {
    @Test
    fun main()
    {
//        val make: (String, String)-> String= { realName, heroName -> "${realName} is now ${heroName}" }   //method 1
//        example("Tony","Iron man", make)


        example("Tony","Iron man", {realName,heroName -> "${realName} is now ${heroName}"})  //method 2

    }
    fun example(realName:String, heroNmae:String, make: (String,String)->String)
    {
        println(make(realName, heroNmae))
    }

}