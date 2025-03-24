package uvis.irin.feature.wordgenerator.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uvis.irin.core.designsystem.components.button.YuzuFilledButton
import uvis.irin.core.designsystem.icons.YuzuIcon
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
internal fun GenerateWordButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    YuzuFilledButton(
        modifier = modifier,
        onClick = onClick,
        icon = YuzuIcon.AiFeature,
    ) {
        Text(text = "Generate a word")
    }
}

@Preview
@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun GenerateWordButtonPreview() {
    YuzuPreview {
        GenerateWordButton(onClick = {})
    }
}
