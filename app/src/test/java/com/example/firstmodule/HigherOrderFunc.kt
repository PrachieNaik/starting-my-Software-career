package com.example.firstmodule

import org.junit.Test

class HigherOrderFunc {
    @Test

    fun main()
    {
        val p = Program();
        p.addTwoNumber(7,10)
        p.addTwoNumber(7,10,object:addTwo{
            override fun execute(sum: Int) {
                println(sum)
            }
        })
    }
    class Program()
    {
        fun addTwoNumber(a:Int,b:Int,action: addTwo)
        {
            val sum=a+b
            action.execute(sum)
        }
        fun addTwoNumber(a:Int,b:Int)// simple
        {
            val temp:Int = a+b;
            println(temp)
        }

    }
    interface addTwo{
        fun execute(sum:Int)
    }
}