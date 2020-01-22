package com.example.firstmodule

import org.junit.Test

class WithApplyFunc1 {
    @Test
    fun main()
    {
        var person= Person()
        with(person)
        {
            name="naik"
            age=20
        }
        person.apply {
            name="naik"
            age=20
        }.startRun()
    }
    class Person
    {
        var name="Prachi"
        var age=10
        fun startRun()
        {
            println("Now I am ready to run")
        }
    }
}