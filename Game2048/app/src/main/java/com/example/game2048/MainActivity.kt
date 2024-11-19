package com.example.game2048

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.game2048.gameengine.GameViewModel
import com.example.game2048.ui.UiBoard
import com.example.game2048.ui.theme.Game2048Theme

class MainActivity : ComponentActivity() {
    private val viewModel = viewModels<GameViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.value.resetGame()
        enableEdgeToEdge()
        setContent {
            Game2048Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UiBoard(
                        viewModel = viewModel.value,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Game2048Theme {
        //Board("Android")
    }
}