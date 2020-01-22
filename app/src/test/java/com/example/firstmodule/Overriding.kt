package com.example.firstmodule

import org.junit.Test

class Overriding{

    @Test
    fun main() {

        var dog = MyDog("Green","breed")

        println(dog.color)

        dog.eat()
    }

    open class MyAnimal {

        open var color: String = "White"

        open fun eat() {
            println("Animal Eating")
        }
        //secondary constructor
        constructor(color: String) {
            this.color = color
            println("From Animal: $color")
        }
    }

    class MyDog : MyAnimal {

        var bread: String = ""

        override var color: String = "Black"

        fun bark() {
            println("Bark")
        }

        override fun eat() {
            //<MyAnimal> is because what if more then one interfaces inherited
            super<MyAnimal>.eat()
            println("Dog is eating")
        }

        constructor(color: String, breed: String): super(color) {
            this.bread = breed

            println("From Dog: $color and $breed")
        }

    }
}