package com.example.firstmodule

import org.junit.Test

class HigherOrderFunc {
    @Test
    fun main()
    {
        val p = Program();
        p.addTwoNumber(7,10)
    }
    class Program()
    {
        fun addTwoNumber(a:Int,b:Int)
        {
            val temp:Int = a+b;
            println(temp)
        }
    }
}