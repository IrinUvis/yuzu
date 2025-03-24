package uvis.irin.core.designsystem.components.divider

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
fun YuzuHorizontalDivider(modifier: Modifier = Modifier) {
    HorizontalDivider(modifier = modifier)
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun YuzuHorizontalDividerPreview() {
    YuzuPreview {
        YuzuHorizontalDivider(modifier = Modifier.padding(4.dp))
    }
}
