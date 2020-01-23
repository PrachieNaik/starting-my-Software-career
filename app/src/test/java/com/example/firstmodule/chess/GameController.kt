package com.example.firstmodule.chess

class GameController(
    val players: List<Player>,
    val board: Board = Board(),
    val ruleEngine: RuleEngine = RuleEngine()
) {
    var currentPlayer: Player? = null

    init {
        currentPlayer = players[0]//randomly choosing first player from the list
    }

    /**
     * 1)current == player
     * 2) validation from rule engine
     * 3) modify board
     */
    fun move(player: Player, from: Point, to: Point): Boolean {
        if (currentPlayer?.id != player.id) {
            return false
        }
        if (!ruleEngine.validMove(board, from, to)) {
            return false
        }

        val movePiece = board.matrix[from.row][from.col].currentIPiece
        board.matrix[to.row][to.col].currentIPiece = movePiece
        board.matrix[from.row][from.col].currentIPiece=null

        return true

    }

}