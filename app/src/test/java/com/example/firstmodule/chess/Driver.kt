package com.example.firstmodule.chess

import org.junit.Test

class Driver {

    @Test
    fun test() {
        val player1 = Player("Prachie", "1234", "human", Color.BLACK)
        val player2 = Player("Deepankur", "5678", "human", Color.WHITE)
        val gameController = GameController(listOf(player1, player2))

        gameController.move(
            player = player1,
            from = Point(1, 0),
            to = Point(2, 0)
        )
    }
}