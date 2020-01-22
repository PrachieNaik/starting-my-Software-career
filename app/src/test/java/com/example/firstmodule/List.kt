package com.example.firstmodule

import org.junit.Test

class List {
    @Test
    fun main()
    {
        var list=ArrayList<String>()
        list.add("Prachi")
        list.add("Naik")
        list[1]="abc"
        for(element in list)
            println(element)
    }


}