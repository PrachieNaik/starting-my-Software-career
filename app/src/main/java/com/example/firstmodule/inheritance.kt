package com.example.firstmodule

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
    fun eat(){
        println("Animal eats")
    }

}
class Dog : Animal(){
    var breed: String = ""

    fun bark(){
        println("Dog bark")
    }
}
class Cat: Animal() {
    var age: Int = -1

    fun meow(){
        println("Cat meow")
    }
}

