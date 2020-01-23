package com.example.firstmodule.chess

class Piece(val mRank: Rank, val mColor: Color) : IPiece {


    override fun getColor(): Color {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRank(): Rank {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toString(): String {
        return "$mRank-$mColor"
    }
}