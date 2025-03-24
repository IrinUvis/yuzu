package uvis.irin.feature.wordgenerator

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
fun WordGeneratorScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier, topBar = {}) {
    }
}

@Preview
@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun WordGeneratorScreenPreview() {
    YuzuPreview {
        WordGeneratorScreen()
    }
}
