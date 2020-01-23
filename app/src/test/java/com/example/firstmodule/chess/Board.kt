package com.example.firstmodule.chess


class Board(
    var matrix: Array<Array<Cell>> = arrayOf()
) {
    init {

        matrix = Array(8) { row ->
            Array(8) { col ->
                Cell()
            }
        }

        makeInitialBoard()

        matrix.forEach { row ->
            row.forEach {
                print(it.currentIPiece.toString())
                print("\t \t" )
            }
            println()
        }
    }


    private fun makeInitialBoard(){
        matrix[0][0].currentIPiece = Piece(Rank.ROOK, Color.BLACK)
    }
}