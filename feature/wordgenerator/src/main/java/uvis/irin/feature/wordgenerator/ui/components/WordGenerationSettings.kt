package uvis.irin.feature.wordgenerator.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
internal fun WordGenerationSettings(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
    }
}

@Preview
@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun WordGenerationSettingsPreview() {
    YuzuPreview {
        WordGenerationSettings()
    }
}
