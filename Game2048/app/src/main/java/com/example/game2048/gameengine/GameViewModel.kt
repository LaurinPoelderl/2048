package com.example.game2048.gameengine

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

enum class Direction {
    TOP,
    BOTTOM,
    LEFT,
    RIGHT
}

class GameViewModel : ViewModel() {
    var state by mutableStateOf(GameState())
    val game2048Engine = Game2048Engine()

    fun move(direction: Direction) {
        when (direction) {
            Direction.TOP -> game2048Engine.moveTop()
            Direction.BOTTOM -> game2048Engine.moveBottom()
            Direction.LEFT -> game2048Engine.moveLeft()
            Direction.RIGHT -> game2048Engine.moveRight()
        }
        game2048Engine.board.forEach {
            println(it)
        }

        println(state.toStringBaseClass())
        // Update the state with the new board after the move
        state = state.copy(board = game2048Engine.board)
        println(state.toStringBaseClass())
    }

    fun resetGame() {
        game2048Engine.init()
        state = state.copy(board = game2048Engine.board)
    }
}