package com.example.firstmodule

import org.junit.Test

class Map {
    @Test
    fun main()
    {
        var map= hashMapOf<Int,String>() //mutable
        map.put(1,"Prachi")
        map.put(2,"Naik")
        map.put(3,"Chetan")

        for(key in map.keys)
            println("Element at $key ${map[key]}")


        var map1= mapOf<Int,String>(1 to "Prachi",2 to "Naik") ///Immutable
        for(key in map1.keys)
            println("Element at $key ${map[key]}")
    }
}