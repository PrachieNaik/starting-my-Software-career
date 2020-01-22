package com.example.firstmodule

import org.junit.Test

class FilterMapSort {
    @Test
    fun main()
    {

        val myNumbers = listOf(2, 3, 4, 6, 23, 90)

        val mySmallNums = myNumbers.filter { it < 10 }    // OR { num -> num < 10 }
        for (num in mySmallNums) {
            println(num)
        }

        val mySquaredNums = myNumbers.map { it * it }     // OR { num -> num * num }
        for (num in mySquaredNums) {
            println(num)
        }

        var people = listOf<Person>(Person(10, "Steve"), Person(23, "Annie"), Person(17, "Sam"))
        var names = people.filter { it.name.startsWith("S") }.map { it.name }

        for (name in names) {
            println(name)
        }
    }

        class Person(var age: Int, var name: String) {
            // Some other code..
        }

}