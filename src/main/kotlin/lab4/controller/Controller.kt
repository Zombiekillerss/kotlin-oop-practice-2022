package lab4.controller

import lab4.model.GAME_NOT_FINISHED
import lab4.model.Model
import lab4.model.State


class Controller(private val model: Model) {
    init {
        startGame()
    }

    private fun startGame() {
        while (model.state in GAME_NOT_FINISHED) {
            val input = readln()
            var state: State = State.STAY
            for (i in input) {
                when (i) {
                    'w' -> state = State.UP_MOVE
                    'a' -> state = State.LEFT_MOVE
                    's' -> state = State.DOWN_MOVE
                    'd' -> state = State.RIGHT_MOVE
                    'e' -> state = State.EXIT
                    'k' -> state = State.KEEP
                }
                try {
                    model.doMove(state)
                } catch (e: Exception) {
                    println(e.message)
                }
            }
            if(state == State.EXIT)
                break
        }
    }
}