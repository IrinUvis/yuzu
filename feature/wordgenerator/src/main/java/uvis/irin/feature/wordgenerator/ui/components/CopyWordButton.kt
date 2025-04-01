package uvis.irin.feature.wordgenerator.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewLightDark
import uvis.irin.feature.wordgenerator.R
import uvis.irin.yuzu.core.designsystem.icons.YuzuIcon
import uvis.irin.yuzu.core.designsystem.preview.YuzuPreview

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
        Text(text = stringResource(R.string.copy_word_button_label))
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
