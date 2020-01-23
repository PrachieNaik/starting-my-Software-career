package com.example.firstmodule.chess

import org.junit.Test

class Driver {

    @Test
    fun test() {
        val player1 = Player("Prachie", "1234", "human", Color.BLACK)
        val player2 = Player("Deepankur", "5678", "human", Color.WHITE)
        GameController(listOf(player1, player2))
    }
}