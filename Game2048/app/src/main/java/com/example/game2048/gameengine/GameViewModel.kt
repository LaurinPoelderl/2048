package com.example.game2048.gameengine

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    var state by mutableStateOf(GameState())
    val game2048Engine = Game2048Engine()

    fun resetGame() {
        game2048Engine.init()
        state = state.copy(board = game2048Engine.board)
    }

    fun moveTop() {
        game2048Engine.moveTop()
        state = state.copy(board = game2048Engine.board)
    }

    fun moveDown() {
        game2048Engine.moveDown()
        state = state.copy(board = game2048Engine.board)
    }

    fun moveLeft() {
        game2048Engine.moveLeft()
        state = state.copy(board = game2048Engine.board)    }

    fun moveRight() {
        game2048Engine.moveRight()
        state = state.copy(board = game2048Engine.board)    }
}