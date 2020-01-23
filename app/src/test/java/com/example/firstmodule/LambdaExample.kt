package com.example.firstmodule

import org.junit.Test

class LambdaExample {
    @Test
    fun main()
    {
        val make: (String, String)-> String= { realName, heroName -> "${realName} is now ${heroName}" }
        example("Tony","Iron man", make)

    }
    fun example(realName:String, heroNmae:String, make: (String,String)->String)
    {
        println(make(realName, heroNmae))
    }

}