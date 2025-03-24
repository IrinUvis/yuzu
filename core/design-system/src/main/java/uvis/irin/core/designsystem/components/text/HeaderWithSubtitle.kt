package uvis.irin.core.designsystem.components.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
fun HeaderWithSubtitle(
    modifier: Modifier = Modifier,
    header: String,
    subtitle: String? = null,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Header(text = header)
        if (subtitle != null) {
            Subtitle(text = subtitle)
        }
    }
}

@Composable
fun Header(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.labelLarge,
    )
}

@Composable
fun Subtitle(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodySmall,
    )
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun HeaderWithSubtitlePreview() {
    YuzuPreview {
        HeaderWithSubtitle(header = "Header", subtitle = "A longer subtitle")
    }
}
