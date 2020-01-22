package com.example.firstmodule

import org.junit.Test

class UseOfIt {
    @Test
    fun main()
    {
        val function= Function();
        function.doReverse("Prachi",{it.reversed()})
    }
    class Function{
        fun doReverse(str:String, myFunc:(String)->String)
        {
            val result=myFunc(str)
            println(result)
        }
    }
}