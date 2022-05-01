package lab4.model

import lab4.model.Cell.*
import java.io.File

enum class Cell(private val textValue: String) {
    PLAYER("P"),
    WALL("#"),
    EXIT("E"),
    EMPTY("-");

    override fun toString(): String = textValue
}

enum class State {
    LEFT_MOVE,
    RIGHT_MOVE,
    UP_MOVE,
    DOWN_MOVE,
    STAY,
    WIN,
    EXIT,
    KEEP
}

val GAME_NOT_FINISHED = setOf(State.LEFT_MOVE, State.RIGHT_MOVE, State.DOWN_MOVE, State.UP_MOVE, State.STAY)

private val FIRST_MOVE = State.STAY

interface ModelChangeListener {
    fun onModelChanged()
}

private val LAB = File("src/main/kotlin/lab4/labyrinth.txt").readLines()
private val BOARD_SIZE_COL = LAB[0].length
private val BOARD_SIZE_ROW = LAB.size

class Model {
    private val _board: MutableList<MutableList<Cell>> = initEmptyBoard()
    private var row = 0
    private var col = 0
    private val board: List<List<Cell>>
        get() = _board

    var state: State = FIRST_MOVE
        private set

    private val listeners: MutableSet<ModelChangeListener> = mutableSetOf()

    fun addModelChangeListener(listener: ModelChangeListener) {
        listeners.add(listener)
    }

    /*fun removeModelChangeListener(listener: ModelChangeListener) {
        listeners.remove(listener)
    }*/

    fun doMove(statePlayer: State) {
        var newR = row
        var newC = col

        when (statePlayer) {
            State.RIGHT_MOVE -> newC++
            State.LEFT_MOVE -> newC--
            State.UP_MOVE -> newR--
            State.DOWN_MOVE -> newR++
            else -> require(statePlayer != State.EXIT) { "Game finished" }
        }

        require(newR in 0 until BOARD_SIZE_ROW && newC in 0 until BOARD_SIZE_COL) { "Wrong move" }
        require(_board[newR][newC] != WALL) { "Wrong move" }

        // check win
        val player = _board[newR][newC]

        // update board
        _board[row][col] = EMPTY
        _board[newR][newC] = PLAYER

        if(statePlayer == State.KEEP)
            saveGame()

        notifyListeners()
        require(!checkWin(player)) {
            state = State.WIN
            "You've completed the maze!"
        }
        row = newR
        col = newC
    }

    private fun saveGame(){
        val writer = File("src/main/kotlin/lab4/labyrinth.txt").bufferedWriter()
        for(i in board){
            for(j in i){
                writer.write(j.toString())
            }
            writer.newLine()
        }
        writer.close()
    }

    private fun notifyListeners() {
        listeners.forEach { it.onModelChanged() }
    }

    private fun checkWin(player: Cell): Boolean {
        return player == EXIT
    }

    private fun initEmptyBoard(): MutableList<MutableList<Cell>> {
        val mapLab = mutableListOf<MutableList<Cell>>()
        var newRow = mutableListOf<Cell>()
        for (i in LAB) {
            for (j in i) {
                when (j) {
                    EMPTY.toString()[0] -> newRow.add(EMPTY)
                    EXIT.toString()[0] -> newRow.add(EXIT)
                    PLAYER.toString()[0] -> newRow.add(PLAYER)
                    WALL.toString()[0] -> newRow.add(WALL)
                }
                if (LAB[row][col] != PLAYER.toString()[0]) {
                    col++
                    col %= i.length
                }
            }
            if (LAB[row][col] != PLAYER.toString()[0])
                row++
            mapLab.add(newRow)
            newRow = mutableListOf()
        }
        return mapLab
    }

    override fun toString(): String {
        return buildString {
            board.forEach {
                append(it).appendLine()
            }
        }
    }
}