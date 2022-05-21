package coursework.controller

import coursework.model.Model

fun charToInt(input: Char):Int{
    when(input){
        'a' -> return 0
        'b' -> return 1
        'c' -> return 2
        'd' -> return 3
        'e' -> return 4
        'f' -> return 5
        'g' -> return 6
        'h' -> return 7
        '1' -> return 0
        '2' -> return 1
        '3' -> return 2
        '4' -> return 3
        '5' -> return 4
        '6' -> return 5
        '7' -> return 6
        '8' -> return 7
        else -> return -1
    }
}

class Controller(private val model: Model) {
    init {
        startGame()
    }

    private fun startGame() {
        /*while (model.state in GAME_NOT_FINISHED) {
            val input = readln().split(" ")
            val whence = Coordinate(0,0)
            val where = Coordinate(0,0)
            whence.col = charToInt(input[1][0])
            whence.row = charToInt(input[1][1])
            where.col = charToInt(input[2][0])
            where.row = charToInt(input[2][1])
            try {
                model.doMove(where, whence)
            } catch (e: Exception) {
                println(e.message)
            }
        }*/
    }
}