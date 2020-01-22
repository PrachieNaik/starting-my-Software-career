package com.example.firstmodule

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun kotlin() {

        fun main(args: Array<String>)
        {
            var dog = Dog()
            dog.breed = "labra"
            dog.color = "black"
            dog.bark()
            dog.eat()

            var cat = Cat()
            cat.age = 7
            cat.color = "brown"
            cat.meow()
            cat.eat()

            var animal = Animal()
            animal.color = "white"
            animal.eat()



        }
        //use of open keyword
        open class Animal
        {
            var color:String=""
            open fun eat(){
                println("Animal eats")
            }

        }
        class Dog : Animal(){
            var breed: String = ""

            fun bark(){
                println("Dog bark")
            }

            //overriding
            override fun eat(){
                println("Dog eat")
            }
        }
        class Cat: Animal() {
            var age: Int = -1

            fun meow(){
                println("Cat meow")
            }
            override fun eat(){
                println("Dog eat")
            }
        }


    }
}
