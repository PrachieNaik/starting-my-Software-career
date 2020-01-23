package com.example.firstmodule.chess

import java.util.*


class Board(
    var matrix: Array<Array<Cell>> = arrayOf()
) {
    init {

        matrix = Array(8) { row ->
            Array(8) { col ->
                Cell()
            }
        }

        print(Arrays.deepToString(matrix))
    }
}