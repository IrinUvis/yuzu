package uvis.irin.yuzu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import uvis.irin.core.designsystem.theme.YuzuTheme
import uvis.irin.feature.wordgenerator.WordGeneratorScreen

class MainActivity : ComponentActivity() {
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
