package com.example.firstmodule

import org.junit.Test

class DataClass {
    @Test
    fun main() {

        var user1 = User("Sam", 10)

        var user2 = User("Sam", 10)

        println(user1.toString())

        if (user1 == user2) //will compare the values and not the objects
            println("Equal")
        else
            println("Not equal")

        var newUser = user1.copy(id = 25)
        println(newUser)
    }

    data class User(var name: String, var id: Int)
}