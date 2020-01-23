package com.example.firstmodule.chess

class GameController(
    val players: List<Player>,
    val board: Board = Board()
) {
    var currentPlayer: Player? = null

    init {
        currentPlayer = players[0]//randomly choosing first player from the list


    }



}