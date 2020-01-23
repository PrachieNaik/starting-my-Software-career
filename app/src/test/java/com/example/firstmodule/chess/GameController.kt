package com.example.firstmodule.chess

class GameController(val players: List<Player>) {
    var currentPlayer: Player? = null

    init {
        Board()
    }

}