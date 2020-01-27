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

    companion object {
        fun printBoard( matrix: Array<Array<Cell>> ){
            matrix.forEach { row ->
                row.forEach {
                    print(it.currentIPiece.toString())
                    print("\t \t" )
                }
                println()
            }
        }
    }



    private fun makeInitialBoard(){
        matrix[0][0].currentIPiece = Piece(Rank.ROOK, Color.BLACK)
        matrix[0][7].currentIPiece = Piece(Rank.ROOK, Color.BLACK)
        matrix[7][0].currentIPiece = Piece(Rank.ROOK, Color.WHITE)
        matrix[7][7].currentIPiece = Piece(Rank.ROOK, Color.WHITE)
        for(element in 0..7)
        {      matrix[1][element].currentIPiece=Piece(Rank.PAWN,Color.BLACK)

        }
        for(element in 0..7)
        {      matrix[6][element].currentIPiece=Piece(Rank.PAWN,Color.WHITE)

        }
        matrix[0][1].currentIPiece = Piece(Rank.KNIGHT, Color.BLACK)
        matrix[0][6].currentIPiece = Piece(Rank.KNIGHT, Color.BLACK)
        matrix[7][1].currentIPiece = Piece(Rank.KNIGHT, Color.WHITE)
        matrix[7][6].currentIPiece = Piece(Rank.KNIGHT, Color.WHITE)


        matrix[0][2].currentIPiece = Piece(Rank.BISHOP, Color.BLACK)
        matrix[0][5].currentIPiece = Piece(Rank.BISHOP, Color.BLACK)
        matrix[7][2].currentIPiece = Piece(Rank.BISHOP, Color.WHITE)
        matrix[7][5].currentIPiece = Piece(Rank.BISHOP, Color.WHITE)

        matrix[0][3].currentIPiece = Piece(Rank.KING, Color.BLACK)
        matrix[0][4].currentIPiece = Piece(Rank.QUEEN, Color.BLACK)
        matrix[7][3].currentIPiece = Piece(Rank.KING, Color.WHITE)
        matrix[7][4].currentIPiece = Piece(Rank.QUEEN, Color.WHITE)
    }
}