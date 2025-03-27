package uvis.irin.feature.wordgenerator.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uvis.irin.core.designsystem.icons.YuzuIcon
import uvis.irin.core.designsystem.preview.YuzuPreview

@Composable
internal fun CopyWordButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        YuzuIcon(icon = YuzuIcon.ContentCopy)
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Copy")
    }
}

@PreviewDynamicColors
@PreviewLightDark
@Composable
private fun CopyWordButtonPreview() {
    YuzuPreview {
        CopyWordButton(onClick = {})
    }
}
