package uvis.irin.yuzu.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import uvis.irin.feature.wordgenerator.ui.WordGeneratorScreen
import uvis.irin.feature.wordgenerator.ui.WordGeneratorViewModel
import uvis.irin.yuzu.core.designsystem.theme.YuzuTheme

class MainActivity : ComponentActivity() {
    val viewModel: WordGeneratorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YuzuTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    WordGeneratorScreen()
                }
            }
        }
    }
}
