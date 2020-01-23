package com.example.firstmodule

import org.junit.Test

sealed class Attribute

class Intelligence : Attribute()

class Agility : Attribute()

class Strength : Attribute()
class SealedClasses {
    @Test
    fun main()
    {

        fun getAttributeString(attribute: Attribute) : String {
            return when (attribute) {
                is Intelligence -> "Intelligence"
                is Strength -> "Strength"
                is Agility -> "Agility"
            }
        }

    }

}