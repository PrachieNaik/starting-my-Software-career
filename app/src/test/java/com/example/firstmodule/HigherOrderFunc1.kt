package com.example.firstmodule

import org.junit.Test

class HigherOrderFunc1 {
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
        val lambda:(Int)->(Unit)={s: Int->println(s)}
        p.addTwoNumber(7,9,lambda)
    }
    class Program
    {
        fun addTwoNumber(a:Int,b:Int,action: addTwo) //interface
        {
            val sum=a+b
            action.execute(sum)
        }
        fun addTwoNumber(a:Int,b:Int)// simple
        {
            val temp:Int = a+b
            println(temp)
        }
        fun addTwoNumber(a:Int,b:Int,action:(Int)->Unit) //Higher order
        {
            val temp:Int=a+b
            action(temp)
        }

    }
    interface addTwo{
        fun execute(sum:Int)
    }
}