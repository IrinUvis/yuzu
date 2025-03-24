package uvis.irin.feature.wordgenerator.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.components.button.YuzuOutlinedButton
import uvis.irin.core.designsystem.components.button.YuzuTextButton
import uvis.irin.core.designsystem.icons.YuzuIcon
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
internal fun GeneratedWordSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GeneratedWord()
        GeneratedWordActions()
        GeneratedWordDescription()
    }
}

@Composable
private fun GeneratedWord(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = "cockroach",
        style = MaterialTheme.typography.titleMedium,
    )
}

@Composable
private fun GeneratedWordActions(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        YuzuTextButton(
            onClick = {},
            icon = YuzuIcon.ContentCopy,
        ) {
            Text(text = "Copy")
        }
        YuzuOutlinedButton(
            onClick = {},
            icon = YuzuIcon.Explain,
        ) {
            Text(text = "Explain meaning")
        }
    }
}

@Composable
private fun GeneratedWordDescription(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = "A cockroach is a hardy insect, often considered a pest, " +
            "that thrives in human environments, particularly warm and " +
            "damp places where food is readily available.",
        style = MaterialTheme.typography.bodyMedium,
    )
}

@Preview
@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun GeneratedWordSectionPreview() {
    YuzuPreview {
        GeneratedWordSection()
    }
}
