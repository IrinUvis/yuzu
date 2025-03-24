package uvis.irin.core.designsystem.components.section

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    text: String,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        style = MaterialTheme.typography.labelLarge,
    )
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun SectionHeaderPreview() {
    YuzuPreview {
        SectionHeader(modifier = Modifier.padding(4.dp), text = "Section header")
    }
}
