package kyr.model

import kyr.model.Cell.*
import java.io.File

//pawn, king, queen, knight, rook, bishop,
//пешка, король, ферзь, конь, ладья, слон
enum class Cell(private val textValue: String) {
    W_PAWN("БП"),
    W_KING("БКР"),
    W_QUEEN("БФ"),
    W_KNIGHT("БК"),
    W_ROOK("БЛ"),
    W_BISHOP("БС"),
    B_PAWN("ЧП"),
    B_KING("ЧКР"),
    B_QUEEN("ЧФ"),
    B_KNIGHT("ЧК"),
    B_ROOK("ЧЛ"),
    B_BISHOP("ЧС"),
    EMPTY(" ");

    override fun toString(): String = textValue
}

data class Coordinate(var row: Int, var col: Int)

enum class State(val textValue: String) {
    WHITE_MOVE("White move"),
    BLACK_MOVE("Black move"),
    WIN_WHITE("White win"),
    WIN_BLACK("Black win"),
    DRAW("Draw")
}

val GAME_NOT_FINISHED = setOf(State.WHITE_MOVE, State.BLACK_MOVE)
val GAME_FINISHED = setOf(State.WIN_BLACK, State.WIN_WHITE, State.DRAW)
val WHITE_FIGURES = setOf(
    W_PAWN,
    W_KING,
    W_QUEEN,
    W_KNIGHT,
    W_ROOK,
    W_BISHOP
)
val BLACK_FIGURES = setOf(
    B_PAWN,
    B_KING,
    B_QUEEN,
    B_KNIGHT,
    B_ROOK,
    B_BISHOP
)

private val FIRST_MOVE = State.WHITE_MOVE

interface ModelChangeListener {
    fun onModelChanged()
}

private val FIELD = File("src/main/kotlin/kyr/chess.txt").readLines()
const val BOARD_SIZE = 8

class Model {
    private val _board: MutableList<MutableList<Cell>> = initEmptyBoard()
    val board: List<List<Cell>>
        get() = _board

    var state: State = FIRST_MOVE
        private set

    private val listeners: MutableSet<ModelChangeListener> = mutableSetOf()

    fun addModelChangeListener(listener: ModelChangeListener) {
        listeners.add(listener)
    }

    fun removeModelChangeListener(listener: ModelChangeListener) {
        listeners.remove(listener)
    }



    fun doMove(where: Coordinate, whence: Coordinate) {
        require(EMPTY != board[whence.row][whence.col]) { "lol" }
        require(board[whence.row][whence.col] == B_BISHOP && (where.row == where.col ||
                7 - whence.col == whence.col)) { "lol" }
    }

    /*private fun saveGame() {
        val writer = File("src/main/kotlin/lab4/labyrinth.txt").bufferedWriter()
        for (i in board) {
            for (j in i) {
                writer.write(j.toString())
                writer.write(" ")
            }
            writer.newLine()
        }
        writer.close()
    }*/

    private fun notifyListeners() {
        listeners.forEach { it.onModelChanged() }
    }

    private fun checkWin(player: Cell): Boolean {
        return false
    }

    private fun initEmptyBoard(): MutableList<MutableList<Cell>> {
        val mapField = mutableListOf<MutableList<Cell>>()
        var newRow = mutableListOf<Cell>()
        for (i in FIELD) {
            val strField = i.split(" ")
            for (j in strField) {
                when (j) {
                    EMPTY.toString() -> newRow.add(EMPTY)
                    W_PAWN.toString() -> newRow.add(W_PAWN)
                    W_KING.toString() -> newRow.add(W_KING)
                    W_QUEEN.toString() -> newRow.add(W_QUEEN)
                    W_KNIGHT.toString() -> newRow.add(W_KNIGHT)
                    W_ROOK.toString() -> newRow.add(W_ROOK)
                    W_BISHOP.toString() -> newRow.add(W_BISHOP)
                    B_PAWN.toString() -> newRow.add(B_PAWN)
                    B_KING.toString() -> newRow.add(B_KING)
                    B_QUEEN.toString() -> newRow.add(B_QUEEN)
                    B_KNIGHT.toString() -> newRow.add(B_KNIGHT)
                    B_ROOK.toString() -> newRow.add(B_ROOK)
                    B_BISHOP.toString() -> newRow.add(B_BISHOP)
                }
            }
            if (newRow.isEmpty()) {
                for (j in 0 until 8) {
                    newRow.add(EMPTY)
                }
            }
            mapField.add(newRow)
            newRow = mutableListOf()
        }
        return mapField
    }

    override fun toString(): String {
        return buildString {
            board.forEach {
                append(it).appendLine()
            }
        }
    }
}