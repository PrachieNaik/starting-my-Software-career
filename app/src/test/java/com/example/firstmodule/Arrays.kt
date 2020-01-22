package com.example.firstmodule

import org.junit.Test

class Arrays {
    @Test
    fun main()
    {
        var array = Array<Int> (5) {0} //Mutable, fixed size
        array[0]=10
        array[4]=10

        for(element in array)
        {
            println(element)
        }

        for(index in 0..array.size-1)
        {
            println(array[index])
        }
    }


}