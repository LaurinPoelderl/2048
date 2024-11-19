package com.example.game2048.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.provider.FontsContractCompat.Columns
import com.example.game2048.gameengine.Direction
import com.example.game2048.gameengine.GameViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UiBoard(viewModel: GameViewModel, modifier: Modifier = Modifier) {
    Column {
        Button(onClick = {
            viewModel.move(Direction.TOP)
        }) {
            Text(
                text = "top"
            )
        }

        val state = viewModel.state
        Row {
            Button(onClick = {
                viewModel.move(Direction.LEFT)
            }) {
                Text(
                    text = "left"
                )
            }

            Column {
                state.board.forEach{ row ->
                    Row(modifier = Modifier.width(200.dp)) {
                        row.forEach { cell ->
                            Ui2048Cell (
                                symbol = "" + cell,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            )
                        }
                    }
                }
            }

            Button(onClick = {
                viewModel.move(Direction.RIGHT)
            }) {
                Text(
                    text = "right"
                )
            }
        }

        Button(onClick = {
            viewModel.move(Direction.BOTTOM)
        }) {
            Text(
                text = "down"
            )
        }
    }
}